package org.example.Model;

public class Delivery extends InterfazModalidadEntrega{
    private Rappi rappi;

    @Override
    public short elegirModalidadEntrega() {
        return Rappi.entregar();
    }
}
