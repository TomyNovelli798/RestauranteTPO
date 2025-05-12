package org.example.Controller;

import org.example.Model.Cliente;
import org.example.Model.Empleado;

public class ControllerNotificacion {
    private Notificacion notificacion;
    private Estado estado;

    public ControllerNotificacion(Notificacion notificacion, Estado estado) {
        this.notificacion = notificacion;
        this.estado = estado;
    }

    public boolean enviarNotificacion(Empleado mozo, Cliente cl) {}
}
