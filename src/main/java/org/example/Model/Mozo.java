package org.example.Model;

import java.util.ArrayList;
import java.util.List;

public class Mozo extends Empleado{

    List<Notificacion> notificaciones;


    public Mozo(String id, String nombre, String apellido, Integer hashContrasenia) {
        super(id, nombre, apellido, hashContrasenia);
        notificaciones = new ArrayList<>();
    }

    @Override
    public void continuarEtapa(Empleado empleado, Pedido pedido) {
        System.out.println("El mozo: Este pedido esta listo para entregar. ");
        pedido.cambiarEstado(Estado.LISTO_PARA_ENTREGAR);

    }




}
