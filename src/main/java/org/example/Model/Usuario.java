package org.example.Model;

public class Usuario {

    private String tipoUsuario;
    private String nombre;
    private String apellido;
    private String contrasenia;

    public Usuario(String tipoUsuario,
                   String nombre,
                   String apellido,
                   String contrasenia) {
        this.tipoUsuario = tipoUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasenia = contrasenia;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }



}
