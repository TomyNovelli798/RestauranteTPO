package org.example.Model;

import java.util.List;

public class Pedido {

    private String idPedido;
    private List<Plato> platos;
    private Cliente cliente;
    private Estado estado;

    public Pedido(String idPedido, List<Plato> platos, Cliente cliente, Estado estado) {
        this.idPedido = idPedido;
        this.platos = platos;
        this.cliente = cliente;
        this.estado = estado;
    }

    public void cambiarEstado() {
    }

    public void notificarCliente() {
    }

    public void enviarFactura() {
    }
}

