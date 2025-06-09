package org.example.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Cliente extends Usuario {

    private Integer hashContrasenia;
    private String correo;
    private List<Notificacion> notificaciones;
    private List<EstrategiaPago> estrategiaPago;

    public Cliente(String tipoUsuario, String nombre, String apellido, String hashContrasenia, String correo) {
        super(tipoUsuario, nombre, apellido, hashContrasenia);
        this.notificaciones = new ArrayList<>();
        this.correo = correo;
        this.estrategiaPago = new ArrayList<>();
    }

    public Integer getHashContrasenia() {
        return this.hashCode();
    }

    public void recibir(Notificacion notificacion) {
        this.notificaciones.add(notificacion);
    }

    public boolean pagar(float monto, String estrategiaPago) {
        for( EstrategiaPago e : this.estrategiaPago) {
            if(e.getClass().getSimpleName().equalsIgnoreCase(estrategiaPago)) {
                return e.pagar(monto);
            }
        }
        return false;
    }


    public String getCorreo() {
        return correo;
    }

}

