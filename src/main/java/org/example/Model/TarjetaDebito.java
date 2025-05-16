package org.example.Model;

public class TarjetaDebito extends Tarjeta{

    private String numero;
    private float balance;

    public TarjetaDebito(String numero) {
        this.numero = numero;
        this.balance = 100000; // hardcodeo
    }

    public boolean pagar(float monto) {
        if(balance >= monto) {
            this.balance -= monto;
            System.out.println("El pago se realizo con exito");
            return true;
        } else {
            System.out.println("El pago no se pudo concretar por falta de fondos.");
            return false;
        }
    }


}
