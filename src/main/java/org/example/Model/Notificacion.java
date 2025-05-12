package org.example.Model;

public record Notificacion(Pedido pedido, Estado estadoPedido, Empleado remitente1, Cliente remitente2) {
}
