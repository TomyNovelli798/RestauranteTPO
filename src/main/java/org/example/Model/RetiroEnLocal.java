package org.example.Model;

public class RetiroEnLocal extends InterfazModalidadEntrega{
    private short tiempoEspera = 0;

    @Override
    public short elegirModalidadEntrega() {
        return tiempoEspera;
    }
}
