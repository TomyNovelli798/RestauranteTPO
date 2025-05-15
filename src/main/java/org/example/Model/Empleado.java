package org.example.Model;

import java.util.List;

public abstract class Empleado {
    private String id;
    private String nombre;
    private List<String> nrosOrdenes

    public Empleado(String id, String nombre, List<String> nrosOrdenes) {
        this.id = id;
        this.nombre = nombre;
        this.nrosOrdenes = nrosOrdenes;
    }

    public void agregarOrden(String nroOrden) {
        this.nrosOrdenes.add(nroOrden);
    }

    abstract void continuarEtapa();

    abstract void Estado();

    abstract boolean recibirNotificacion(Notificacion notificacion);
}
