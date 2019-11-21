package com.example.deberpractica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Eliminar extends AppCompatActivity {
Bundle datos;
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
    private TextView textoservicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);
        datos= getIntent().getExtras();
        String nombrestr=datos.getString("nombre");
        String apellidostr=datos.getString("apellido");
        String telefonostr=datos.getString("telefono");
        String emailstr=datos.getString("email");
        String generostr=datos.getString("genero");
        String fechastr=datos.getString("fecha");
        String asignaturasstr=datos.getString("asignaturas");
        String becadostr=datos.getString("becado");
        String usuarioistr=datos.getString("usuarioi");
        String claveistr=datos.getString("clavei");
        int pos=datos.getInt("posi");
        //usuario = (EditText) findViewById(R.id.editText5);
        //clave=(EditText)findViewById(R.id.editText6);
        nombre = (EditText) findViewById(R.id.editText9);
        apellido=(EditText)findViewById(R.id.editText11);
        email = (EditText) findViewById(R.id.editText13);
        celular=(EditText)findViewById(R.id.editText12);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        check1=(CheckBox)findViewById(R.id.checkBox7);
        check2=(CheckBox)findViewById(R.id.checkBox6);
        check3=(CheckBox)findViewById(R.id.checkBox10);
        check4=(CheckBox)findViewById(R.id.checkBox9);
        check5=(CheckBox)findViewById(R.id.checkBox8);
        sp1=(Spinner)findViewById(R.id.spinner7);
        sp2=(Spinner)findViewById(R.id.spinner8);
        sp3=(Spinner)findViewById(R.id.spinner5);
        sw1=(Switch)findViewById(R.id.switch2);
        btn1=(Button) findViewById(R.id.button);
        String [] parts = fechastr.split("/");
        //System.out.println(parts.length+"tamaño");
        String diastr="";
        String messtr="";
        String aniostr="";
        if (parts.length==3) {
            diastr = parts[0];
            messtr = parts[1];
            aniostr = parts[2];
        }else{
            Toast.makeText(Eliminar.this,"ERROR DE ENTRADA DE DATOS",Toast.LENGTH_LONG).show();

        }
        String [] dia ={"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"};
        ArrayAdapter <String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,dia);
        sp1.setAdapter(adapter);
        List<String> listadia = Arrays.asList(dia);
        sp1.setSelection(listadia.indexOf(diastr));

        String [] mes ={"01","02","03","04","05","06","07","08","09","10","11","12"};
        ArrayAdapter <String> adapter1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mes);
        sp2.setAdapter(adapter1);
        List<String> listames = Arrays.asList(mes);
        sp2.setSelection(listames.indexOf(messtr));

        String [] anio ={"1981","1982","1983","1984","1985","1986","1987","1988","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009"};
        ArrayAdapter <String> adapter2=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,anio);
        sp3.setAdapter(adapter2);
        List<String> listaanio = Arrays.asList(anio);
        sp3.setSelection(listaanio.indexOf(aniostr));

        nombre.setText(nombrestr);
        apellido.setText(apellidostr);
        email.setText(emailstr);
        celular.setText(telefonostr);
        if (generostr.equals("hombre")){
            rb1.toggle();
        }else{
            rb2.toggle();
        }
        String [] parts2 = asignaturasstr.split("-");
        //System.out.println(parts.length+"tamaño");
        if (parts2.length>=3) {
            for (int i=0;i<parts2.length;i++){
                String asig = parts2[i];
                switch (asig) {
                    case "Filosofia":
                        check1.setChecked(true);
                        break;
                    case "Deporte":
                        check2.setChecked(true);
                        break;
                    case "Informatica":
                        check3.setChecked(true);
                        break;
                    case "Matematicas":
                        check4.setChecked(true);
                        break;
                    case "Ciencias":
                        check5.setChecked(true);
                        break;
                }
            }
        }else{
            Toast.makeText(Eliminar.this,"ERROR DE ENTRADA DE DATOS",Toast.LENGTH_LONG).show();

        }
        if(becadostr.equals("si")){
            sw1.setChecked(true);
        }else{
            sw1.setChecked(false);
        }

    }
}
