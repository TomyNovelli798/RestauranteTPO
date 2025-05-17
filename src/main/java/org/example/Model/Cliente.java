package org.example.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Cliente extends Usuario {

    private Integer hashContrasenia;
    private String correo;
    private List<Notificacion> notificaciones;
    private Optional<TarjetaCredito> tarjetaCredito;
    private Optional<TarjetaDebito> tarjetaDebito;

    public Cliente(String tipoUsuario, String nombre, String apellido, String hashContrasenia, String correo) {
        super(tipoUsuario, nombre, apellido, hashContrasenia);
        this.notificaciones = new ArrayList<>();
        this.tarjetaCredito = Optional.of(new TarjetaCredito("111111"));
        this.tarjetaDebito = Optional.of(new TarjetaDebito("222222"));
        this.correo = correo;
    }

    public Integer getHashContrasenia() {
        return this.hashCode();
    }

    public void recibir(Notificacion notificacion) {
        this.notificaciones.add(notificacion);
    }

    public boolean pagar(float monto, String tipoTarjeta) {
        if(tipoTarjeta.equalsIgnoreCase("Credito") && tarjetaCredito.isPresent()) {
            return tarjetaCredito.get().pagar(monto);
        } else if(tipoTarjeta.equalsIgnoreCase("Debito") && tarjetaDebito.isPresent()) {
            return tarjetaDebito.get().pagar(monto);
        }
        return false;
    }

    public String getCorreo() {
        return correo;
    }

}

