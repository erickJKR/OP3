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
    private String archivo ="miarchivo8";
    private String carpeta= "/archivos/";
    File file;
    String file_path="";
    String name="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        usuariosListar = (TextView) findViewById(R.id.textView3);
        sp1=(Spinner)findViewById(R.id.spinner4);
        this.file_path=(Environment.getExternalStorageDirectory()+this.carpeta);
        File localFile=new File(this.file_path);
        if(!localFile.exists()){
            localFile.mkdir();
        }
        this.name=(this.archivo +".txt");
        this.file=new File(localFile,this.name);
        try{
            this.file.createNewFile();
            //escribir("admin", "admin","david","lara","dllara@uce.edu.ec","0998124155","hombre","23/10/1995","Fisica-Ciencias-Informatica-","si");

        }catch (IOException e){
            e.printStackTrace();
        }
        final String usuariosDetalles[] =leer();
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

    public  String[] leer(){
        String contenido="";
        FileInputStream fin=null;
        String matriz[] = new String[1000];

        int n=0;
        try{
            fin= new FileInputStream(file);

        }catch(FileNotFoundException e1){
            e1.printStackTrace();
        }
        InputStreamReader archivo=new InputStreamReader(fin);
        BufferedReader br=new BufferedReader(archivo);
        int ascii;
        try{
            //while ((ascii=br.read())!= -1){
            // char caracter=(char) ascii;
            //contenido+=caracter;

            //}
            String linea;
            int i = 0;
            while ((linea = br.readLine()) != null) {
                matriz[i] = linea;
                i=i+1;
            }
            n=i;


        }catch (IOException e){
            e.printStackTrace();
        }
        //Log.e(tag="leer",contenido);

        String usuariosDetalles[] = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println(matriz[i]);
            usuariosDetalles[i]  = matriz[i] ;
            System.out.println(usuariosDetalles[i]+"metodo leer");
        }
//       claveTextView.setText(usuariosDetalles[n-1]);
        //System.out.println(usuariosDetalles[n-1]+"llllllllllllllllllllllllll");

        return usuariosDetalles;
    }
    public void escribir(String usua, String clave,String nombre,String apellido,String email,String telefono,String genero,String fecha,String asignaturas,String becado){
        FileWriter fichero=null;
        PrintWriter pw =null;
        try{
            //fichero=new FileWriter(file);
            fichero=new FileWriter(file.getAbsoluteFile(), true);
            pw=new PrintWriter(fichero);
            //pw.println(usuarioTextView.getText().toString());
            pw.println(usua+" "+clave+" "+nombre+" "+apellido+" "+email+" "+telefono+" "+genero+" "+fecha+" "+asignaturas+" "+becado);
            pw.flush();
            pw.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if (null!= fichero)
                    fichero.close();
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }
}

