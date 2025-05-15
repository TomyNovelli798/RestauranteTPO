package org.example.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ServicePedido {

    private List<Pedido> pedidos;

    public ServicePedido() {
        this.pedidos = new ArrayList<>();
    }

    public void nuevoPedido(Map<String, Integer> producto, Cliente cliente, Estado estado  ) {
        Pedido pedido = new Pedido(producto, cliente, estado);
        this.pedidos.add(pedido);

    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public String getUltimoPedido() {
        return this.pedidos.getLast().getIdPedido();
    }
}
