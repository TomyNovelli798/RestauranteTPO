package org.example.Model;

public class Chef extends Empleado{
    private boolean estaPedidoListo;
    public Chef(String id, String nombre) {
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

    public boolean cocinarComida(){
        return true;
    }
}
