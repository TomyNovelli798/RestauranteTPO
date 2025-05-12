package org.example.Model;

public class NotificacionesPorCorreoElectronico implements EstrategiaNotificacion {

    private Cliente cliente;

    @Override
    public boolean enviarNotificacion() {
        return false;
    }
}
