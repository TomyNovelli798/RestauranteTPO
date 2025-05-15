package org.example.Model;

import java.util.ArrayList;
import java.util.List;

public class Mozo extends Empleado{
    private List<Notificacion> notificaciones;

    public Mozo(String id, String nombre) {
        super(id, nombre, new ArrayList<>());
        notificaciones = new ArrayList<>();
    }

    @Override
    void continuarEtapa() { // Continuar con esta logica

    }

    @Override
    void Estado() { // Verificar si este metodo sirve

    }

    @Override
    boolean recibirNotificacion(Notificacion notificacion) {
        notificaciones.add(notificacion);
        System.out.println("Notificacion recibida: " + notificacion.toString());
        return true;
    }

    public void cocinar() { // continuar esta logica

    }




}
