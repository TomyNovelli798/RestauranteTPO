package org.example.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Empleado extends Usuario {

    private String nombre;
    private List<Notificacion> casillaSistema;

    public Empleado(String tipoUsuario, String nombre, String apellido, Integer hashContrasenia ) {
        super(tipoUsuario, nombre, apellido, hashContrasenia);
        this.nombre = nombre;
        this.casillaSistema = new ArrayList<>();
    }

    public void recibir(Notificacion notificacion) {
        this.casillaSistema.add(notificacion);
    }

    public abstract void continuarEtapa(Empleado empleado, Pedido pedido);



    @Override
    public String getNombre() {
        return nombre;
    }

    public List<Notificacion> getCasillaSistema() {
        return casillaSistema;
    }
}
