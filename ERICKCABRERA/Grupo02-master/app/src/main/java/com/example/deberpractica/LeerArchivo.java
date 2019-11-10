package com.example.deberpractica;

import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class LeerArchivo {
    private String archivo = "miarchivo9";
    private String carpeta = "/archivos/";
    File file;
    String file_path = "";
    String name = "";

    public LeerArchivo() {

        this.archivo = archivo;
        this.file_path = (Environment.getExternalStorageDirectory() + this.carpeta);
        File localFile = new File(this.file_path);
        if (!localFile.exists()) {
            localFile.mkdir();
        }
        this.name = (this.archivo + ".txt");
        this.file = new

                File(localFile, this.name);
        try {
            this.file.createNewFile();
            if(!file.exists()) {
                escribir("admin", "admin", "david", "lara", "dllara@uce.edu.ec", "0998124155", "hombre", "23/10/1995", "Fisica-Ciencias-Informatica-", "si");
            }
            } catch (
                IOException e) {
            e.printStackTrace();
        }
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
    public  ArrayList<String> leer(){
        FileInputStream fin=null;
        //String matriz[] = new String[1000];
        ArrayList<String> matriz = new ArrayList<String>();
        int n=0;
        try{
            fin= new FileInputStream(file);

        }catch(FileNotFoundException e1){
            e1.printStackTrace();
        }
        InputStreamReader archivo=new InputStreamReader(fin);
        BufferedReader br=new BufferedReader(archivo);
        try{
            String linea;
            //int i = 0;
            while ((linea = br.readLine()) != null) {
                //matriz[i] = linea;
                matriz.add(linea);
                //i=i+1;
            }
            n=matriz.size()+1;


        }catch (IOException e){
            e.printStackTrace();
        }

        return matriz;
    }
    public  ArrayList<String> leerColumna(int j){
        ArrayList<String> usuariosAreglos= new ArrayList<String>();
        //ArrayList<String> claveAreglos= new ArrayList<String>();
        ArrayList<String> usuariosDetalles =this.leer();
        for (int i = 0; i < usuariosDetalles.size(); i++) {
            System.out.println(usuariosDetalles.get(i)+"leer");
            String [] parts = usuariosDetalles.get(i).split(" ");
            System.out.println(parts.length+"tamaño");
            String usuarioi = parts[j];
            System.out.println(usuarioi+" vector usuario");
            //String clavei = parts[1];
            //System.out.println(usuarioi + " - " + clavei);
            usuariosAreglos.add(usuarioi);
            //claveAreglos.add(clavei);

            // }
        }
        return usuariosAreglos;
    }
}

