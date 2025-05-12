package org.example.Model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MenuEspecifico extends Componente {

    private String nombre;
    private List<Componente> elementos;

    public MenuEspecifico(String nombre) {
        this.nombre = nombre;
        this.elementos = new ArrayList<>();
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
