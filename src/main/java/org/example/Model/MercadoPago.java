package org.example.Model;

public abstract class MercadoPago extends EstrategiaPago {

    private String email;
    private String contrasenia;
    private float balance;

    public boolean pagar(float monto) {
        balance -= monto;
        return true;
    }

}
