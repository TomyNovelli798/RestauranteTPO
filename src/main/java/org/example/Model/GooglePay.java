package org.example.Model;

public abstract class GooglePay extends EstrategiaPago {

    private String email;
    private String contrasenia;
    private float balance;

    public boolean pagar(float monto) {
        this.balance -= monto;
        return true;
    }

}
