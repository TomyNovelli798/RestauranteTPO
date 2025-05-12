package org.example.Model;

public class NotificacionPorSistema implements EstrategiaNotificacion {

    private Empleado mozo;

    public boolean enviarNotificacionPorSistema(Notificacion n, Empleado mozo){
        return true;
    }

    @Override
    public boolean enviarNotificacion() {
        return false;
    }
}
