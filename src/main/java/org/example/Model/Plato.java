package org.example.Model;

abstract class Plato extends Componente {

    private String descripcion;
    private float precio;
    private boolean ingredienteAlergenico;

    public Plato(String descripcion, float precio, boolean ingredienteAlergenico) {
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
    public Componente eliminar() {
        return null;
    }
}

