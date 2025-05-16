package org.example.Model;

import java.util.ArrayList;
import java.util.List;

public class ServiceNotificacion {
    private List<Notificacion> notificaciones; //guarda las notificaciones

    public ServiceNotificacion( ) {
        this.notificaciones = new ArrayList<>();
    }

    public boolean enviarNotificacion(Pedido pedido, Usuario usuario) {

        Notificacion notificacion = new Notificacion(pedido.getProductos(), pedido.getEstado());
        this.notificaciones.add(notificacion);

        Notificador notificador;

        if(usuario instanceof Cliente) {
            notificador = new Notificador(new NotificacionesPorCorreoElectronico(), notificacion);
        } else {
            notificador = new Notificador(new NotificacionPorSistema(), notificacion);
        }
        return notificador.enviarNotificacion(notificacion, usuario);

    }
}
