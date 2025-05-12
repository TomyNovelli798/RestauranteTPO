package org.example.Model;

public class Pago {
    private CuponDescuento descuento;
    private Tarjeta tarjeta;

    public Pago(CuponDescuento descuento, Tarjeta tarjeta) {
        this.descuento = descuento;
        this.tarjeta = tarjeta;
    }
}
