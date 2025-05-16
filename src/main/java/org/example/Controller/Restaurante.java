package org.example.Controller;

import org.example.Model.*;

import java.util.*;

public class Restaurante {
    private Componente menu;
    private List<Empleado> empleados;
    private ServiceNotificacion serviceNotificacion;
    private ServiceUsuario serviceUsuario;
    private ServicePedido servicePedido;

    public Restaurante(Componente menu) {
        this.menu = menu;
        this.empleados = new ArrayList<>();
        this.serviceNotificacion = new ServiceNotificacion();
        this.serviceUsuario = new ServiceUsuario();
        this.servicePedido = new ServicePedido();
    }

    public void registrarUsuario(String tipoUsuario,
                                 String nombre,
                                 String apellido,
                                 Integer hashContrasenia,
                                 String correo ) {
        this.serviceUsuario.registrarUsuario(tipoUsuario, nombre, apellido, hashContrasenia, correo);
    }

    public boolean iniciarSesion(String nombre, String contrasenia) {
        return this.serviceUsuario.iniciarSesion(nombre, contrasenia);
    }

    public boolean cerrarSesion() {
        return this.serviceUsuario.cerrarSesion();
    }

    public float calcularPedido(Map<String, Integer> productos) {
        float total = 0;
        Set<String> nombres = productos.keySet();
        for(String nombre : nombres) {
            total+= this.menu.getPrecio(nombre);
        }
        return total;
    }

    public void hacerPedido(String cupon, Map<String, Integer> productos) {
        float precioTotal = this.calcularPedido(productos);
        if(Optional.of(this.serviceUsuario.getUsuarioActual()).isEmpty()) {
            System.out.println("Primero inicia sesion.");
            return;
        }
        float descuento = this.servicePedido.isCupon(cupon);
        if(descuento > 0) {
            precioTotal -= descuento;
        }




        this.servicePedido.nuevoPedido(productos, (Cliente)this.serviceUsuario.getUsuarioActual(), precioTotal);


        System.out.println("Pedido"+this.servicePedido.getUltimoNroPedido()+", actualmente se encuentraen estado de espera.");
        for(Empleado empleado : this.empleados) {
            if(empleado instanceof Mozo) {
                this.serviceNotificacion.enviarNotificacion(this.servicePedido.getUltimoPedido(), empleado);
            }
        }
    }

    public void pagoPedido(float monto, String tipoTarjeta) {
        this.serviceUsuario.pagoCliente(monto, tipoTarjeta);
    }

    public void cambiarEstado(Empleado empleado, Pedido pedido) {
        if (pedido.getEstado().equals(Estado.ENTREGADO)) {
            System.out.println("Estado entregado");
            return;
        }
        empleado.continuarEtapa(empleado, pedido);
    }

    public String generarInforme(Empleado admin) {
        return this.serviceUsuario.generarInformeAdmin();
    }

    public boolean notificacionPedido(Pedido pedido, Usuario usuario) {
        return this.serviceNotificacion.enviarNotificacion(pedido, usuario);
    }

}
