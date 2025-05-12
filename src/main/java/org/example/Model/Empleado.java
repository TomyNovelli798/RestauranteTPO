package org.example.Model;

public abstract class Empleado {
    private String id;
    private String nombre;

    public Empleado(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    abstract void Estado();

    abstract boolean recibirNotificacion();
}
