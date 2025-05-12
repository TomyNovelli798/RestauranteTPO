package org.example.Model;

public class NotificacionesPorCorreoElectronico implements EstrategiaNotificacion {

    private Cliente cliente;

    @Override
    public boolean enviarNotificacion(Notificacion notificacion) {
        String cliente = notificacion.remitente2().getNombre() + " " + notificacion.remitente2().getApellido();
        String estado = notificacion.estadoPedido().name();
        System.out.println("El cliente "+ cliente + " tiene su pedido en estado: " + estado);
        return true;
    }
}
