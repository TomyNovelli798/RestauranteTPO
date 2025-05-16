package org.example.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Pedido {

    private static Integer ID_CONTADOR = 0;
    private String idPedido;
    private Map<String, Integer> productos; // String --> Producto - Integer --> Cantidad
    private Cliente cliente;
    private Estado estado;
    private float precioTotal;

    public Pedido(Map<String, Integer> productos, Cliente cliente, float precioTotal) {
        ID_CONTADOR=+1;
        this.idPedido=ID_CONTADOR.toString();
        this.productos = productos;
        this.cliente = cliente;
        this.estado = Estado.EN_ESPERA;
        this.precioTotal = precioTotal;
    }

    public void cambiarEstado(Estado estado) {this.estado = estado;}

    public String getIdPedido() {
        return idPedido;
    }

    public Estado getEstado() {
        return estado;
    }

    public List<String> getProductos () {
        return new ArrayList<>(productos.keySet());
    }

}

