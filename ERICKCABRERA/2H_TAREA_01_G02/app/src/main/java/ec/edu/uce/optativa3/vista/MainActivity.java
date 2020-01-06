package ec.edu.uce.optativa3.vista;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.deberpractica.R;

import java.util.ArrayList;

import ec.edu.uce.optativa3.controlador.DaoUsuario;
import ec.edu.uce.optativa3.controlador.LeerArchivo;
import ec.edu.uce.optativa3.controlador.ListaEstudiantes;
import ec.edu.uce.optativa3.controlador.ObtenerServicio;

public class MainActivity extends AppCompatActivity {
    private Button btn1;
    private Button btn2;
    private EditText usuarioTextView;
    private EditText claveTextView;
    String usuarioTxt;
    String claveTxt;
    private TextView textoservicio;
    private ObtenerServicio obtener = new ObtenerServicio();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button) findViewById(R.id.buttonIngreso);
        btn2=(Button) findViewById(R.id.buttonRegistro);
        usuarioTextView = (EditText) findViewById(R.id.editText);//texto de ingreso de usuario
        claveTextView=(EditText)findViewById(R.id.editText2);//texto de ingreso de clave
        textoservicio=(TextView)findViewById(R.id.textView);
        textoservicio.setText(obtener.getDato(3));
        //obtener.RealizarPost(this);
        cargarpreferencias();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usuarioTxt= (String) usuarioTextView.getText().toString();
                claveTxt= (String) claveTextView.getText().toString();
                DaoUsuario dao=new DaoUsuario(MainActivity.this);
                if (dao.login(usuarioTxt,claveTxt)>0) {
                    Toast.makeText(MainActivity.this, obtener.servicioExamen(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this,"Usuario y clave correcto",Toast.LENGTH_LONG).show();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            Intent intent=new Intent(MainActivity.this,Listar.class);
                            //intent.putExtra()
                            startActivity(intent);
                            guardarpreferencias();
                            finish();
                        }
                    }, 2000);
                } else{

                            Toast.makeText(MainActivity.this,"Credenciales incorectas",Toast.LENGTH_LONG).show();
                        }

                    }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,RegistroUsuario.class);
                        //intent.putExtra()
                        startActivity(intent);
                        //eliminarpreferencias();
                        cargarpreferencias();
                        finish();
            }
        });
    }

@Override
public boolean onCreateOptionsMenu(Menu miMenu){
getMenuInflater().inflate(R.menu.menu, miMenu);
return true;
}

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.login:
                Intent intent=new Intent(MainActivity.this,MainActivity.class);
                //intent.putExtra()
                startActivity(intent);
                eliminarpreferencias();
                cargarpreferencias();
                finish();
                return true;
            case R.id.salir:
                finish();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    public void cargarpreferencias(){
    SharedPreferences preferencias=getSharedPreferences("credenciales", Context.MODE_PRIVATE);
    String user=preferencias.getString( "user","");
    String pass=preferencias.getString("pass","");
    usuarioTextView.setText(user);
    claveTextView.setText(pass);
}

    public void guardarpreferencias(){
        SharedPreferences preferencias=getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        String user= usuarioTextView.getText().toString();
        String pass= claveTextView.getText().toString();
        SharedPreferences.Editor editor=preferencias.edit();
        editor.putString("user",user);
        editor.putString("pass",pass);
        editor.commit();
    }
    public void eliminarpreferencias(){
        SharedPreferences preferencias=getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferencias.edit();
        editor.clear();
        editor.commit();
    }



}



