package com.example.deberpractica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Listar extends AppCompatActivity {
    private TextView usuariosListar;
    private Spinner sp1;
    private LeerArchivo archivos=new LeerArchivo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        usuariosListar = (TextView) findViewById(R.id.textView3);
        sp1=(Spinner)findViewById(R.id.spinner4);

        final String usuariosDetalles[] =archivos.leer();
        String usuariosAreglos[]= new String[usuariosDetalles.length];
        String claveAreglos[] = new String[usuariosDetalles.length];
        for (int i = 0; i < usuariosDetalles.length; i++) {
            System.out.println(usuariosDetalles[i]+"leer");
            String [] parts = usuariosDetalles[i].split(" ");
            System.out.println(parts.length+"tamaño");
            String usuarioi = parts[0];
            System.out.println(usuarioi+" vector usuario");
            String clavei = parts[1];
            System.out.println(usuarioi + " - " + clavei);
            usuariosAreglos[i] = usuarioi;
            claveAreglos[i] = clavei;
            // }
        }
        //String [] usuaruiosAreglo ={"01","02","03","04","05","06","07","08","09","10","11","12"};
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,usuariosAreglos);
        sp1.setAdapter(adapter1);
        sp1.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> spn,
                                               android.view.View v,
                                               int posicion,
                                               long id) {
                        Toast.makeText(spn.getContext(), "Has seleccionado " +
                                        spn.getItemAtPosition(posicion).toString(),
                                Toast.LENGTH_LONG).show();
                        String [] parts = usuariosDetalles[posicion].split(" ");
                        //System.out.println(parts.length+"tamaño");
                        String usuarioi = parts[0];
                        String clavei = parts[1];
                        String nombre = parts[2];
                        String apellido = parts[3];
                        String email = parts[4];
                        String telefono = parts[5];
                        String genero = parts[6];
                        String fecha=parts[7];
                        String asignaturas = parts[8];
                        String becado = parts[9];
                        String detallesUsuarioElegido="nombre: "+nombre+"\n"+"apellido: "+apellido+"\n"+"email: "+email+"\n"+"telefono: "+telefono+"\n"+"genero: "+genero+"\n"+"fecha: "+fecha+"\n"+"asignatura: "+asignaturas+"\n"+"becado: "+becado;
                        usuariosListar.setText(detallesUsuarioElegido);
                    }
                    public void onNothingSelected(AdapterView<?> spn) {
                    }
                });

    }


}

