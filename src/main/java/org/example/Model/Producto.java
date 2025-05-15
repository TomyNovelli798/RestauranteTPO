package org.example.Model;

import java.util.List;

public abstract class Producto extends Componente {

    private String descripcion;
    private float precio;
    private boolean ingredienteAlergenico;

    public Producto(String nombre, String descripcion, float precio, boolean ingredienteAlergenico) {
        super(nombre);
        this.descripcion = descripcion;
        this.precio = precio;
        this.ingredienteAlergenico = ingredienteAlergenico;
    }

    @Override
    public boolean iniciarOrdenCompra() {
        return false;
    }

    @Override
    public boolean seleccionarProducto(String plato) {
        return false;
    }

    @Override
    public Componente añadir() {
        return null;
    }

    @Override
    public Componente getHijo() {
        return null;
    }

    @Override
    public List<Componente> getHijos() { // funcion sobrante
        return null;
    }

    @Override
    public Componente eliminar() {
        return null;
    }

    public float getPrecio() {
        return precio;
    }




}

