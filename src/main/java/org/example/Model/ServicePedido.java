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

    public void nuevoPedido(Map<String, Integer> producto, Cliente cliente, float precioTotal, String horario, short tiempoEspera, String modalidadEntrega) {
        Pedido pedido = new Pedido(producto, cliente, precioTotal, horario, tiempoEspera, modalidadEntrega);
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



    public short tiempoEsperaPedido(String idPedido) {
        for (Pedido p : this.pedidos) {
            if(p.getIdPedido().equals(idPedido)) {
                return p.getTiempoEspera();
            }
        }
        return -1; // no existe el pedido
    }

    public short calcularEsperaPedido() {
        short espera = 0;
        for (Pedido p : this.pedidos) {
            if ( p.getEstado().toString().equals("EN_ESPERA")) {
                espera++;
            }
        }
        return (short) ((espera/10)*20);
    }

    public float cancelarPedido(String idPedido){
        for(Pedido pedido : this.pedidos){
            if(pedido.getIdPedido().equals(idPedido)) return pedido.cancelar();
        }
        throw new IllegalArgumentException("No se encontró ningún pedido con ese ID");
    }

    public void agregarProducto(String idPedido, Map<String, Integer> nuevosProductos, float precioAdicional) {
        for(Pedido pedido : pedidos){
            if(pedido.getIdPedido().equals(idPedido)) {
                pedido.agregarProductos(nuevosProductos, precioAdicional);
                return;
            }
        }
        throw new IllegalArgumentException("No se encontró un pedido con ese ID para agregarlo");
    }
}
