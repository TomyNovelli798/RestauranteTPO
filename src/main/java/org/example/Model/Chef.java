package org.example.Model;

public class Chef extends Empleado{
    public Chef(String id, String nombre, String apellido, String contrasenia) {
        super(id, nombre, apellido, contrasenia);
    }

    @Override
    public void continuarEtapa(Empleado empleado, Pedido pedido) {
        System.out.println("El chef: El pedido esta preparandose.");
        pedido.setEstado(Estado.EN_PREPARACION);
    }

}
