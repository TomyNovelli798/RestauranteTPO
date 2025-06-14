package org.example.Model;

import java.util.List;

public class
Producto extends Componente {


    private String descripcion;
    private float precio;
    private boolean ingredienteAlergenico;
    private short tiempoBaseEspera;

    public Producto(String nombre, String descripcion, float precio, boolean ingredienteAlergenico, short tiempoBaseEspera) {
        super(nombre);
        this.descripcion = descripcion;
        this.precio = precio;
        this.ingredienteAlergenico = ingredienteAlergenico;
        this.tiempoBaseEspera = tiempoBaseEspera;
    }


    @Override
    public void añadir(Componente comp) {}

    @Override
    public Componente getHijo() {
        return null;
    }

    @Override
    public List<Componente> getHijos() { // funcion sobrante
        return null;
    }

    @Override
    public void eliminar(Componente componente) {}

    @Override
    public float getPrecio(String producto) {
        return 0;
    }

    public float getPrecio() {
        return precio;
    }

    public short getTiempoBaseEspera() {return this.tiempoBaseEspera;}




}

