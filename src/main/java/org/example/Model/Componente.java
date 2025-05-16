package org.example.Model;

import java.util.List;

public abstract class Componente  {

    private String nombre;

    public Componente(String nombre) {
        this.nombre = nombre;
    }

    public abstract void añadir(Componente comp);

    public abstract Componente getHijo();

    public abstract List<Componente> getHijos();

    public abstract void eliminar(Componente comp);

    public abstract float getPrecio(String producto);

    public String getNombre() {
        return nombre;
    }
}
