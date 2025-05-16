package org.example.Model;

public class NotificacionesPorCorreoElectronico implements EstrategiaNotificacion {


    @Override
    public boolean enviarNotificacion(Notificacion notificacion, Usuario usuario) {
        String estado = notificacion.estado().name();
        ((Cliente) usuario).recibir(notificacion);
        System.out.println("Cliente "+ usuario.getNombre() + " tiene su pedido en estado: " + estado);
        return true;
    }
}
