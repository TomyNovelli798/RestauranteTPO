package org.example.Model;

public class Notificador {

    private EstrategiaNotificacion estrategia;
    private Notificacion notificacion;

    public Notificador(EstrategiaNotificacion estrategia, Notificacion notificacion) {
        this.estrategia = estrategia;
        this.notificacion = notificacion;
    }

    public boolean enviarNotificacion(Notificacion notificacion) {
        return this.estrategia.enviarNotificacion(notificacion);
    }
}
