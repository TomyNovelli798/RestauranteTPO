package org.example.Model;

import java.util.ArrayList;
import java.util.List;

public class Chef extends Empleado{
    private boolean estaPedidoListo;
    private List<Notificacion> notificaciones;
    public Chef(String id, String nombre) {
        super(id, nombre, new ArrayList<>());
        estaPedidoListo = false;
        notificaciones = new ArrayList<Notificacion>();

    }

    @Override
    void Estado() {

    }

    @Override
    boolean recibirNotificacion(Notificacion notificacion) {
        this.notificaciones.add(notificacion);
        System.out.println("Notificacion recibida: " + notificacion.toString());
        return true;
    }

    public boolean cocinarComida(){
        return true;
    }
}
