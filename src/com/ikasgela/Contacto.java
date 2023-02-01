package com.ikasgela;

public class Contacto {

    private String nombre;
    private String apellidos;
    private String email;

    //Constructor
    public Contacto(String nombre, String apellidos, String email) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
    }

    //Getters and setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Utilities
    @Override
    public String toString() {
        return String.format("| %-25s | %-25s | %-25s |\n", nombre, apellidos, email);
    }
}
