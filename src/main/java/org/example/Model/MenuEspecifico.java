package org.example.Model;

import java.util.ArrayList;
import java.util.List;

public class MenuEspecifico extends Componente {

    private List<Componente> elementos;

    public MenuEspecifico(String nombre) {
        super(nombre);
        this.elementos = new ArrayList<>();
    }

    @Override
    public void añadir(Componente comp) {
        this.elementos.add(comp);
    }

    @Override
    public Componente getHijo() {
        return null;
    }

    @Override
    public List<Componente> getHijos() {
        return elementos;
    }

    @Override
    public void eliminar(Componente componente) {
        this.elementos.remove(componente);
    }

    @Override
    public float getPrecio(String producto) {
        if(this.elementos.isEmpty()) {
            return -1; // indicando que este menu no tiene items
        }
        return buscadorPrecio(producto, this.getHijos());
    }

    private float buscadorPrecio(String producto, List<Componente> items) {
        for(Componente elemento : items) {
            if(elemento instanceof Producto && elemento.getNombre().equals(producto)) {
                 return ((Producto) elemento).getPrecio();
            } else if(elemento instanceof MenuEspecifico) {
                buscadorPrecio(producto, elemento.getHijos());
            }
        }
        return -1; // indica no haberlo encontrado
    }
}
