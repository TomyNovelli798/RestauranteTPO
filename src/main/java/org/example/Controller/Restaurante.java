package org.example.Controller;

import org.example.Model.*;

import java.util.*;

public class Restaurante {
    private Componente menu;
    private List<Empleado> empleados;
    private ServiceNotificacion serviceNotificacion;
    private ServiceCliente serviceCliente;
    private ServicePedido servicePedido;

    public Restaurante(Componente menu) {
        this.menu = menu;
        this.empleados = new ArrayList<>();
        this.serviceNotificacion = new ServiceNotificacion();
        this.serviceCliente = new ServiceCliente();
        this.servicePedido = new ServicePedido();
    }


    public float calcularPedido(Map<String, Integer> productos) {
        float total = 0;
        Set<String> nombres = productos.keySet();
        for(String nombre : nombres) {
            total+= this.menu.getPrecio(nombre);
        }
        return total;
    }

    public void hacerPedido(String monto, String cupon, Map<String, Integer> productos) {
        if(Optional.of(this.serviceCliente.getClienteActual()).isEmpty()) {
            System.out.println("Primero inicia sesion.");
            return;
        }

        this.servicePedido.nuevoPedido(productos, this.serviceCliente.getClienteActual(), Estado.EN_ESPERA);
        System.out.println("Pedido confirmado, actualmente se encuentraen estado de espera.");
        for(Empleado empleado : this.empleados) {
            if(empleado instanceof Mozo) {
                empleado.agregarOrden(this.servicePedido.getUltimoPedido());
            }
        }
    }

    public boolean notificacionPedido() {
        this.serviceNotificacion.enviarNotificacion()
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
