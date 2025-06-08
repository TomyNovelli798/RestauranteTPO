package org.example.Model;

public abstract class Efectivo extends EstrategiaPago {
    private float porcentajeDescuento;

    public Efectivo() {
        this.porcentajeDescuento = 0.1f;
    }
}
