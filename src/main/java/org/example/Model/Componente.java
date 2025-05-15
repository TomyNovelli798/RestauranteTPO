package org.example.Model;

import java.util.List;

public abstract class Componente  {

    private String nombre;

    public Componente(String nombre) {
        this.nombre = nombre;
    }

    public abstract boolean iniciarOrdenCompra();

    public abstract boolean seleccionarProducto(String plato);

    public abstract Componente añadir();

    public abstract Componente getHijo();

    public abstract List<Componente> getHijos();

    public abstract Componente eliminar();

    public abstract float getPrecio(String producto);

    public String getNombre() {
        return nombre;
    }
}
