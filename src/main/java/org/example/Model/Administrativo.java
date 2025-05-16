package org.example.Model;

import java.util.*;

public class Administrativo extends Empleado{
    public Administrativo(String tipoUsuario, String nombre, String apellido, Integer hashContrasenia) {
        super(tipoUsuario, nombre, apellido, hashContrasenia);
    }

    @Override
    public void continuarEtapa(Empleado empleado, Pedido pedido) {
        System.out.println("Administrador: Este pedido esta entregado.");
        pedido.cambiarEstado(Estado.ENTREGADO);
    }


    public String generarInforme() {
        List<Notificacion> notificaciones = getCasillaSistema();
        Map<String, Integer> parametros = contabilizar(notificaciones);
        Set<String> keys = parametros.keySet();
        StringBuilder informeArray = new StringBuilder();
        informeArray.append("El informe de ventas son: \n");
        while(!keys.isEmpty()) {
            String p = keys.iterator().next();
            informeArray.append("Producto: ").append(p).append("  Cantidad: ").append(parametros.get(p)).append("\n");
            keys.remove(p);
        }
        return informeArray.toString();
    }

    private Map<String, Integer> contabilizar(List<Notificacion> n) {
        Map<String, Integer> cantidad = new HashMap<>();
        for(Notificacion notificacion : n) {
            for (String producto : notificacion.productos()) {
                cantidad.put(producto, cantidad.getOrDefault(producto, 0) + 1);
            }
        }
        return cantidad;
    }



}
