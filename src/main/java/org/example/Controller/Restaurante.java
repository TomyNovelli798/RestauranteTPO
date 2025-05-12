package org.example.Controller;

import org.example.Model.Componente;
import org.example.Model.Empleado;
import org.example.Model.Pedido;
import org.example.Model.Plato;

import java.util.List;

public class Restaurante {
    private Componente menu;
    private List<Empleado> empleados;
    private List<Pedido> pedidos;

    public Restaurante(Componente menu,
                       List<Empleado> empleados,
                       List<Pedido> pedidos) {
        this.menu = menu;
        this.empleados = empleados;
        this.pedidos = pedidos;
    }

    public boolean hacerPedido(Plato plato) {
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
