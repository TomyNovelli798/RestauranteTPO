package org.example.Model;

public class Cliente {

    private String nombre;
    private String apellido;
    private String dni;
    private String direccion;
    private String correo;

    public Cliente(String nombre, String apellido, String dni, String direccion, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.direccion = direccion;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}

