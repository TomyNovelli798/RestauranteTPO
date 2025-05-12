package org.example.Model;

public class Ticket {

    private boolean tieneCupon;
    private Pedido pedido;
    private float monto;
    private float IVA;
    private CuponDescuento cupon;

    public Ticket(boolean tieneCupon, Pedido pedido, float monto, float IVA, CuponDescuento cupon) {
        this.tieneCupon = tieneCupon;
        this.pedido = pedido;
        this.monto = monto;
        this.IVA = IVA;
        this.cupon = cupon;
    }
}

