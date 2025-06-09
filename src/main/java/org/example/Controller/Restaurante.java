package org.example.Controller;

import org.example.Model.*;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

public class Restaurante {
    private Componente menu;
    private List<Empleado> empleados;
    private ServiceNotificacion serviceNotificacion;
    private ServiceUsuario serviceUsuario;
    private ServicePedido servicePedido;
    private Plataforma plataforma;

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
                                 String contrasenia,
                                 String correo ) {
        this.serviceUsuario.registrarUsuario(tipoUsuario, nombre, apellido, contrasenia, correo);
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

    public void hacerPedido(
            String cupon,
            Map<String, Integer> productos,
            String horario,
            Plataforma plataforma,
            String modalidadEntrega
    ) {
        float precioTotal = this.calcularPedido(productos);
        if(Optional.of(this.serviceUsuario.getUsuarioActual()).isEmpty()) {
            System.out.println("Primero inicia sesion.");
            return;
        }

        if (plataforma.equals(Plataforma.APP)) {
            float descuento = this.servicePedido.isCupon(cupon);
            if(descuento > 0) {
                precioTotal -= descuento;
            }
        }

        if(Objects.equals(horario, "")) {
            horario = getTiempoActual();
        }

        this.servicePedido.nuevoPedido(
                productos,
                (Cliente)this.serviceUsuario.getUsuarioActual(),
                precioTotal, horario,
                calcularEsperaPedido(),
                modalidadEntrega
        );

        System.out.println("Pedido"+this.servicePedido.getUltimoNroPedido()+", actualmente se encuentra en estado de espera.");
        if (plataforma.equals(Plataforma.APP)) {
            for(Empleado empleado : this.empleados) {
                if(empleado instanceof Mozo) {
                    this.serviceNotificacion.enviarNotificacion(this.servicePedido.getUltimoPedido(), empleado);
                }
            }
        }
    }

    public boolean pagoPedido(float monto, String estrategiaPago) {
        return this.serviceUsuario.pagoCliente(monto, estrategiaPago);
    }

    public void cambiarEstado(Pedido pedido) {
        if(pedido.getEstado().equals(Estado.EN_ESPERA)) {
            pedido.setEstado(Estado.EN_PREPARACION);
            pedido.setTiempoEspera(calcularPreparacionPedido(pedido));

        } else if(pedido.getEstado().equals(Estado.EN_PREPARACION)) {
            pedido.setEstado(Estado.LISTO_PARA_ENTREGAR);
            pedido.setTiempoEspera(pedido.tiempoEntrega());

        } else if(pedido.getEstado().equals(Estado.LISTO_PARA_ENTREGAR)) {
            pedido.setEstado(Estado.ENTREGADO);

        } else if(pedido.getEstado().equals(Estado.ENTREGADO)) {
            System.out.println("Estado entregado");
        }

    }

    public String generarInforme(Empleado admin) {
        return this.serviceUsuario.generarInformeAdmin();
    }

    public boolean notificacionPedido(Pedido pedido, Usuario usuario) {
        return this.serviceNotificacion.enviarNotificacion(pedido, usuario);
    }

    public short tiempoEsperaPedido(String idPedido) {
        return this.servicePedido.tiempoEsperaPedido(idPedido);
    }

    public Componente getMenu() {
        return menu;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public ServiceNotificacion getServiceNotificacion() {
        return serviceNotificacion;
    }

    public ServiceUsuario getServiceUsuario() {
        return serviceUsuario;
    }

    public ServicePedido getServicePedido() {
        return servicePedido;
    }


    private String getTiempoActual() {
        LocalDateTime fechaHora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return fechaHora.format(formato);
    }

    private short calcularEsperaPedido() {
        return (short) (this.servicePedido.calcularEsperaPedido() + 5);
    }

    private short calcularPreparacionPedido(Pedido pedido) {
        short preparacion = 0;
        Map productos = pedido.getTodosProductos();
        Set pSet = productos.keySet();
        while( !pSet.isEmpty() ) {
            String p = (String)pSet.iterator().next();
            preparacion = (short) (tomarTiempoBase(this.menu, p) * (Integer) productos.get(p));
            pSet.remove(p);
        }
        return preparacion;
    }

    private short tomarTiempoBase(Componente menu, String producto) {
        List<Componente> menusEspecificos = menu.getHijos();
        for (Componente m : menusEspecificos) {
            List<Componente> productos = m.getHijos();
            for (Componente p : productos) {
                Producto pp = (Producto) p;
                if (pp.getNombre().equals(producto)) {
                    return pp.getTiempoBaseEspera();
                }
            }
        }
        return 0;
    }

}
