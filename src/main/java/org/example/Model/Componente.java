package org.example.Model;

public abstract class Componente  {

    public Componente() {
        // Constructor por defecto
    }

    public abstract boolean iniciarOrdenCompra();

    public abstract boolean seleccionarProducto(String plato);

    public abstract Componente añadir();

    public abstract Componente getHijo();

    public abstract Componente eliminar();

}
