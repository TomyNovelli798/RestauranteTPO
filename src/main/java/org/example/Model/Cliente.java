package org.example.Model;

public class Cliente {

    private String nombre;
    private String apellido;
    private String contrasenia;
    private String direccion;
    private String correo;

    public Cliente(String nombre, String apellido, String contrasenia, String direccion, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasenia = contrasenia;
        this.direccion = direccion;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getHashContrasenia() {
        return this.hashCode();
    }
}

