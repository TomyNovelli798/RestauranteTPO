package org.example.Model;

import java.util.Map;

public class Pedido {

    private static Integer ID_CONTADOR = 0;
    private String idPedido;
    private Map<String, Integer> productos; // String --> Producto - Integer --> Cantidad
    private Empleado empleado;
    private Cliente cliente;
    private Estado estado;

    public Pedido(Map<String, Integer> productos, Cliente cliente, Estado estado) {
        ID_CONTADOR=+1;
        this.idPedido=ID_CONTADOR.toString();
        this.productos = productos;
        this.cliente = cliente;
        this.estado = estado;
    }

    public void cambiarEstado() {
    }

    public void notificarCliente() {
    }

    public void enviarFactura() {
    }

    public String getIdPedido() {
        return idPedido;
    }
}

