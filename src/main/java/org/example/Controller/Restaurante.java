package org.example.Controller;

import org.example.Model.Componente;
import org.example.Model.Empleado;

import java.util.List;

public class Restaurante {
    private Componente menu;
    private List<Empleado> empleados;
    private List<Pedidos> pedidos;

    public Restaurante(Componente menu,
                       List<Empleado> empleados,
                       List<Pedidos> pedidos) {
        this.menu = menu;
        this.empleados = empleados;
        this.pedidos = pedidos;
    }

    public boolean hacerPedido() {
        return true;
    }

    public boolean notificacionPedido() {
        return true;
    }

    public boolean gestionarPedido(Pedido p) {
        return true;
    }

    public boolean actualizarMenu() {
        return true;
    }

    public void cambiarEstado(Empleado e){

    }

}
