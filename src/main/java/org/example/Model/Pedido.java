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
    private String horario;
    private short tiempoEspera;
    private InterfazModalidadEntrega modalidadEntrega;


    public Pedido(Map<String, Integer> productos, Cliente cliente, float precioTotal, String horario, short tiempoEspera, String modalidad) {
        ID_CONTADOR=+1;
        this.idPedido=ID_CONTADOR.toString();
        this.productos = productos;
        this.cliente = cliente;
        this.estado = Estado.EN_ESPERA;
        this.precioTotal = precioTotal;
        this.modalidadEntrega = defModalidadEntrafa(modalidad);
    }

    public void setEstado(Estado estado) {this.estado = estado;}



    // public void entrega(modalidad : InterfazModalidadEntrega) {...}


    public String getIdPedido() {
        return idPedido;
    }

    public Estado getEstado() {
        return estado;
    }

    public Map getTodosProductos() {
        return productos;
    }

    public void setTiempoEspera(short tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }


    public List<String> getProductos () {
        return new ArrayList<>(productos.keySet());
    }

    public Cliente getCliente() {return cliente;}

    public String getHorario() {return horario;}
    public short getTiempoEspera() {return tiempoEspera;}

    public boolean puedeCancelar(){
        return estado == Estado.EN_ESPERA || estado == Estado.EN_PREPARACION;
    }

    //Toda la logica para cancelar y los reembolsos
    public float cancelar(){
        if(!puedeCancelar()){
            throw new IllegalStateException("El estado no puede ser cancelado en este estado");
        }
        this.estado = Estado.CANCELADO;
        return precioTotal * 0.75f;//Reembolso del 75%
    }

    public boolean puedeAgregarProductos(){
        return estado == Estado.EN_ESPERA;
    }

    public void agregarProductos(Map<String, Integer> nuevosProductos, float precioAdicional){
        if(!puedeAgregarProductos()){
            throw new IllegalStateException("No se pueden agregar productos a un pedido que no está en espera.");
        }
        for(Map.Entry<String, Integer> producto: nuevosProductos.entrySet()){
            productos.merge(producto.getKey(), producto.getValue(), Integer::sum);
        }
        this.precioTotal += precioAdicional;//Se cobra de nuevo el producto agregado
    }

    public short tiempoEntrega() {
        return modalidadEntrega.elegirModalidadEntrega();
    }

    private InterfazModalidadEntrega defModalidadEntrafa(String modalidad) {
        if(modalidad.equalsIgnoreCase("Rappi")){
            return new Delivery();
        }
        return new RetiroEnLocal();
    }
}

