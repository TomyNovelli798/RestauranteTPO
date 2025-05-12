package org.example.Model;

public class Administrativo extends Empleado{
    private boolean estaPedidoListo;
    public Administrativo(String id, String nombre) {
        super(id, nombre);
        estaPedidoListo = false;
    }

    @Override
    void Estado() {

    }

    @Override
    boolean recibirNotificacion() {
        return false;
    }

    public String generarInforme() {
        return "";
    }
}
