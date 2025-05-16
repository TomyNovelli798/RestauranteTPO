package org.example.Model;

public class NotificacionPorSistema implements EstrategiaNotificacion {

    @Override
    public boolean enviarNotificacion(Notificacion notificacion, Usuario usuario) {
        Empleado puesto = (Empleado) usuario;
        String contexto = "";
        puesto.recibir(notificacion);

        System.out.println("El " +
                usuario.getClass().getName() +
                " define el estado: "+
                notificacion.estado().name().toLowerCase());

        return true;
    }
}
