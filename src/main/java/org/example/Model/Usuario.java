package org.example.Model;

public class Usuario {

    private String tipoUsuario;
    private String nombre;
    private String apellido;
    private Integer hashContrasenia;

    public Usuario(String tipoUsuario,
                   String nombre,
                   String apellido,
                   Integer hashContrasenia) {
        this.tipoUsuario = tipoUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.hashContrasenia = hashContrasenia;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public Integer getHashContrasenia() {
        return hashContrasenia;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }



}
