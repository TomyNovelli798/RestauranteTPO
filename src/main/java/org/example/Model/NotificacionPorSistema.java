package org.example.Model;

public class NotificacionPorSistema implements EstrategiaNotificacion {

    @Override
    public boolean enviarNotificacion(Notificacion notificacion) {
        String empleado = notificacion.remitente1().getClass().toString();
        String estado = notificacion.estadoPedido().name();
        System.out.println("El "+empleado+" define el estado "+estado);
        return true;
    }
}
