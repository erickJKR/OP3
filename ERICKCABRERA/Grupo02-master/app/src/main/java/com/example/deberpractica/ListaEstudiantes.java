package com.example.deberpractica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ListaEstudiantes {
    Estudiante u;
    ArrayList<Estudiante> lista;
    private String archivo ="miarchivo8";
    private String carpeta= "/archivos/";

    File file;
    String file_path="";
    String name="";
    public void testinputoutput() {

        ArrayList<Estudiante> arrayList1 = new ArrayList<Estudiante>();
        ArrayList<Estudiante> arrayList2;
        System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
        System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
        System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
        System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
        System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
        System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
        System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
        System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
        System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
        System.out.println("Datos que vamos a escribir en el fichero:");
        for (int i = 0; i < 10; i++) {
            Estudiante nuevoObjeto = new Estudiante("Cadena" + i);
            arrayList1.add(nuevoObjeto);
            System.out.println("arrayList1[" + i + "] = " + arrayList1.get(i));
        }

        try {
            System.out.print("Guardando ArrayList en el fichero objetos.dat.. ");

            ObjectOutputStream escribiendoFichero = new ObjectOutputStream(
                    new FileOutputStream("objetos.dat"));
            escribiendoFichero.writeObject(arrayList1);
            escribiendoFichero.close();

            System.out.println("ok!");
            System.out.print("Leyendo ArrayList del fichero objetos.dat.. ");

            ObjectInputStream leyendoFichero = new ObjectInputStream(
                    new FileInputStream("objetos.dat"));
            arrayList2 = (ArrayList<Estudiante>) leyendoFichero.readObject();
            leyendoFichero.close();

            System.out.println("ok!");
            System.out.println("Datos leídos del fichero:");

            for (int i = 0; i < arrayList2.size(); i++) {
                System.out.println("arrayList2[" + i + "] = " + arrayList2.get(i));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
    public  String[] leer(){
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
        try{
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
        String usuariosDetalles[] = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println(matriz[i]);
            usuariosDetalles[i]  = matriz[i] ;
            System.out.println(usuariosDetalles[i]+"metodo leer");
        }
        return usuariosDetalles;
    }





}
