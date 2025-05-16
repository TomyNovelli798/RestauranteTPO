package org.example.Model;

import java.util.ArrayList;
import java.util.List;

public class Chef extends Empleado{
    public Chef(String id, String nombre, String apellido, Integer hashContrasenia) {
        super(id, nombre, apellido, hashContrasenia);
    }

    @Override
    public void continuarEtapa(Empleado empleado, Pedido pedido) {
        System.out.println("El chef: El pedido esta preparandose.");
        pedido.cambiarEstado(Estado.EN_PREPARACION);
    }

}
