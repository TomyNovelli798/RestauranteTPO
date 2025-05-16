package org.example.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ServicePedido {

    private List<Pedido> pedidos;
    private List<Cupon> cupones;

    public ServicePedido() {
        this.cupones = List.of(
                new Cupon("comida123", 0.25F),
                new Cupon("delicioso321", 0.1F),
                new Cupon("resto", 0.2F)
                );
        this.pedidos = new ArrayList<>();
    }

    public void nuevoPedido(Map<String, Integer> producto, Cliente cliente, float precioTotal) {
        Pedido pedido = new Pedido(producto, cliente, precioTotal);
        this.pedidos.add(pedido);

    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public Pedido getUltimoPedido() { return this.pedidos.getLast();}

    public String getUltimoNroPedido() {
        return this.pedidos.getLast().getIdPedido();
    }

    public float isCupon(String cupon) {
        for (Cupon c : cupones) {
            if(Objects.equals(cupon, c.codigo())) {
                return c.descuento();
            }
        }
        return -1F;
    }

}
