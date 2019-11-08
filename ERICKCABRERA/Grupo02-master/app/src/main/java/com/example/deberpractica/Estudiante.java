package com.example.deberpractica;

public class Estudiante {
    private String usuario;
    private String clave;
    private String nombre;
    private String apellido;
    private String email;
    private String celular;
    private String foto;
    private String genero;
    private String fechaNacimiento;
    private String[ ] asignatura = new String[2];
    private String becado;


    public Estudiante(String usuario, String clave, String nombre, String apellido, String email, String celular, String foto, String genero, String fechaNacimiento, String[] asignatura, String becado) {
        this.usuario = usuario;
        this.clave = clave;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.celular = celular;
        this.foto = foto;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.asignatura = asignatura;
        this.becado = becado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String[] getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String[] asignatura) {
        this.asignatura = asignatura;
    }

    public String getBecado() {
        return becado;
    }

    public void setBecado(String becado) {
        this.becado = becado;
    }
}
