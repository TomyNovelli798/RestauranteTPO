package org.example.Model;

import java.util.ArrayList;
import java.util.List;

public class Mozo extends Empleado{
    private boolean estaPedidoListo;
    private List<Notificacion> notificaciones;
    public Mozo(String id, String nombre) {
        super(id, nombre);
        estaPedidoListo = false;
        notificaciones = new ArrayList<Notificacion>();
    }

    @Override
    void Estado() {

    }

    @Override
    boolean recibirNotificacion(Notificacion notificacion) {
        notificaciones.add(notificacion);
        System.out.println("Notificacion recibida: " + notificacion.toString());
        return true;
    }

    public boolean retirarPedido() {}
}
