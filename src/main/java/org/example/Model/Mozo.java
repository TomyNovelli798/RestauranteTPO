package org.example.Model;

public class Mozo extends Empleado{
    private boolean estaPedidoListo;
    public Mozo(String id, String nombre) {
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

    public boolean retirarPedido() {}
}
