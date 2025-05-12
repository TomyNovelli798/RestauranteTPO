package org.example.Controller;

import org.example.Model.*;

import java.util.ArrayList;
import java.util.List;

public class ControllerNotificacion {
    private List<Notificacion> notificaciones; //guarda las notificaciones

    public ControllerNotificacion( ) {
        this.notificaciones = new ArrayList<>();
    }

    public boolean enviarNotificacion(Pedido pedido, Empleado mozo, Cliente cliente, EstrategiaNotificacion estrategia, Estado estado) {

        Notificacion notificacion = new Notificacion(pedido, estado, mozo, cliente);
        this.notificaciones.add(notificacion);

        Notificador notificador = new Notificador(estrategia, notificacion);
        return notificador.enviarNotificacion(notificacion);

    }
}
