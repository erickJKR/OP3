package com.example.deberpractica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Registro extends AppCompatActivity {
    private EditText usuario;
    private EditText clave;
    private EditText nombre;
    private EditText apellido;
    private EditText email;
    private EditText celular;
    private RadioButton rb1,rb2;
    private CheckBox check1,check2,check3,check4,check5;
    private Spinner sp1,sp2,sp3;
    private Switch sw1;
    private Button btn1;
    private LeerArchivo archivos=new LeerArchivo();
    private ListaEstudiantes arch=new ListaEstudiantes();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        usuario = (EditText) findViewById(R.id.editText5);
        clave=(EditText)findViewById(R.id.editText6);
        nombre = (EditText) findViewById(R.id.editText7);
        apellido=(EditText)findViewById(R.id.editText8);
        email = (EditText) findViewById(R.id.editText3);
        celular=(EditText)findViewById(R.id.editText4);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton);
        check1=(CheckBox)findViewById(R.id.checkBox);
        check2=(CheckBox)findViewById(R.id.checkBox2);
        check3=(CheckBox)findViewById(R.id.checkBox3);
        check4=(CheckBox)findViewById(R.id.checkBox4);
        check5=(CheckBox)findViewById(R.id.checkBox5);
        sp1=(Spinner)findViewById(R.id.spinner);
        sp2=(Spinner)findViewById(R.id.spinner2);
        sp3=(Spinner)findViewById(R.id.spinner3);
        sw1=(Switch)findViewById(R.id.switch1);
        btn1=(Button) findViewById(R.id.button);

        String [] dia ={"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15}","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"};
        ArrayAdapter <String> adapter=new ArrayAdapter <String> (this,android.R.layout.simple_list_item_1,dia);
        sp3.setAdapter(adapter);
        String [] mes ={"01","02","03","04","05","06","07","08","09","10","11","12"};
        ArrayAdapter <String> adapter1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mes);
        sp1.setAdapter(adapter1);
        String [] anio ={"1981","1982","1983","1984","1985","1986","1987","1988","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009"};
        ArrayAdapter <String> adapter2=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,anio);
        sp2.setAdapter(adapter2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuarioTxt = (String) usuario.getText().toString();
                String claveTxt = (String) clave.getText().toString();
                String nombreTxt = (String) nombre.getText().toString();
                String apellidoTxt = (String) apellido.getText().toString();
                String emailTxt = (String) email.getText().toString();
                String celularTxt = (String) celular.getText().toString();
                String generoTxt;
                String becadoTxt;
                String asignaturas = "";
                if (rb1.isChecked() == true) {
                    generoTxt = "hombre";
                } else {
                    generoTxt = "mujer";
                }
                int contadorCheck = 0;
                if (check1.isChecked() == true) {
                    asignaturas = asignaturas + "Ciencias-";
                    contadorCheck = contadorCheck + 1;
                }
                if (check2.isChecked() == true) {
                    asignaturas = asignaturas + "Filosofia-";
                    contadorCheck = contadorCheck + 1;
                }
                if (check3.isChecked() == true) {
                    asignaturas = asignaturas + "Matematicas-";
                    contadorCheck = contadorCheck + 1;
                }
                if (check4.isChecked() == true) {
                    asignaturas = asignaturas + "Informatica-";
                    contadorCheck = contadorCheck + 1;
                }
                if (check5.isChecked() == true) {
                    asignaturas = asignaturas + "Deporte-";
                    contadorCheck = contadorCheck + 1;
                }
                String dia = sp2.getSelectedItem().toString();
                String mes = sp3.getSelectedItem().toString();
                String anio = sp1.getSelectedItem().toString();
                String fechaTxt = dia + "/" + mes + "/" + anio;
                if (sw1.isChecked() == true) {
                    becadoTxt = "si";
                } else {
                    becadoTxt = "no";
                }
                if (!usuarioTxt.isEmpty() && !claveTxt.isEmpty() && validarEntrada(usuarioTxt) && validarEntrada(claveTxt) && validarEntrada(nombreTxt) && validarEntrada(apellidoTxt) && validarEntrada(emailTxt) && validarEntrada(celularTxt)) {
                    if ((!archivos.leerColumna(0).contains(usuarioTxt)) && (contadorCheck >= 3)) {
                        archivos.escribir(usuarioTxt, claveTxt, nombreTxt, apellidoTxt, emailTxt, celularTxt, generoTxt, fechaTxt, asignaturas, becadoTxt);
                        arch.escribir();
                        Intent intent = new Intent(Registro.this, MainActivity.class);
                        //intent.putExtra()
                        startActivity(intent);
                        finish();

                    } else {
                        if (archivos.leerColumna(0).contains(usuarioTxt)) {
                            Toast.makeText(Registro.this, "Nombre de usuario ya existe", Toast.LENGTH_LONG).show();

                        }
                        if (contadorCheck < 3) {
                            Toast.makeText(Registro.this, "Esliga al menos 3 asignaturas", Toast.LENGTH_LONG).show();

                        }
                        if (contadorCheck < 3) {
                            Toast.makeText(Registro.this, "Escoja al menos 3 asignaturas", Toast.LENGTH_LONG).show();

                        }

                    }

                }
            }

public boolean validarEntrada(String str){
        if (str.indexOf(" ")<0){
            return true;
        }else{
            return false;
        }
}

}
