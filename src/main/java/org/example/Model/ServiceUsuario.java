package org.example.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServiceUsuario {

    private Optional<Usuario> usuarioActual;
    private final List<Usuario> usuarios;
    private final List<Pedido> pedidos;

    public ServiceUsuario() {
        this.usuarioActual = Optional.empty();
        this.usuarios = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    public Usuario getUsuarioActual() {
        if (usuarioActual.isEmpty()) {
            System.out.println("Usuario no encontrado");
            return null;
        }
        return usuarioActual.get();
    }

    public void registrarUsuario(String tipoUsuario, String nombre, String apellido, String contrasenia, String correo) {

        for(Usuario empleado : usuarios) {
            if ( empleado.getNombre().equalsIgnoreCase(nombre) && empleado.getContrasenia().equalsIgnoreCase(contrasenia)) {
                System.out.println("Usuario ya registrado");
                return;
            }
        }
        this.usuarios.add(new Cliente(tipoUsuario, nombre, apellido, contrasenia, correo));

    }

    public boolean iniciarSesion(String nombre, String contrasenia) {
        if (this.usuarioActual.isPresent()) {
            System.out.println("Primero cierra la sesion actual.");
            return false;
        }
        for (Usuario cliente : usuarios) {
            if (cliente.getNombre().equalsIgnoreCase(nombre) && cliente.getContrasenia().equalsIgnoreCase(contrasenia)) {
                this.usuarioActual = Optional.of(cliente);
                System.out.println("Se inicia la sesion.");
                return true;
            }
        }
        System.out.println("Primero registrate.");
        return false;
    }

    public boolean cerrarSesion() {
        if (this.usuarioActual.isPresent()) {
            this.usuarioActual = Optional.empty();
            System.out.println("Se cierra la sesion.");
            return false;
        }
        System.out.println("Primero cierra la sesion.");
        return true;
    }

    public boolean pagoCliente(float monto, String estrategiaPago) {
        return ((Cliente) usuarioActual.get()).pagar(monto, estrategiaPago);
    }

    public String generarInformeAdmin() {
        return ((Administrativo) this.usuarioActual.get()).generarInforme();
    }
}
