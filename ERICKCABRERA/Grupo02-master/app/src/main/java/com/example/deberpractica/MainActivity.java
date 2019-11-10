package com.example.deberpractica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MainActivity extends AppCompatActivity {
    private Button btn1;
    private Button btn2;
    private EditText usuarioTextView;
    private EditText claveTextView;
    String usuarioTxt;
    String claveTxt;
    private LeerArchivo archivos=new LeerArchivo();
        ListaEstudiantes listarEstudiantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button) findViewById(R.id.buttonIngreso);
        btn2=(Button) findViewById(R.id.buttonRegistro);
        usuarioTextView = (EditText) findViewById(R.id.editText);//texto de ingreso de usuario
        claveTextView=(EditText)findViewById(R.id.editText2);//texto de ingreso de clave

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usuarioTxt= (String) usuarioTextView.getText().toString();
                claveTxt= (String) claveTextView.getText().toString();

                String usuariosDetalles[] =archivos.leer();
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

                for (int i = 0; i < usuariosDetalles.length; i++) {
                    if (usuariosAreglos[i].equals(usuarioTxt)){
                        if(claveAreglos[i].equals(claveTxt)){
                            System.out.println("Usuario y clave correcto");
                            Toast.makeText(MainActivity.this,"Usuario y clave correcto",Toast.LENGTH_LONG).show();
                            Intent intent=new Intent(MainActivity.this,Listar.class);
                            //intent.putExtra()
                            startActivity(intent);

                        }else{
                            System.out.println("Clave incorrecta");
                            Toast.makeText(MainActivity.this,"Clave incorrecta",Toast.LENGTH_LONG).show();
                        }
                        break;
                    }else{
                        if (i==usuariosAreglos.length-1){
                            System.out.println("No existe Usuario");
                            Toast.makeText(MainActivity.this,"No existe Usuario",Toast.LENGTH_LONG).show();
                        }
                    }
                }

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Registro.class);
                        //intent.putExtra()
                        startActivity(intent);
            }
        });
    }


}



