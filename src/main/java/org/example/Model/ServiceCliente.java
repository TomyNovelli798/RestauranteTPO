package org.example.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServiceCliente {

    private Optional<Cliente> clienteActual;
    private final List<Cliente> clientes;

    public ServiceCliente() {
        this.clienteActual = Optional.empty();
        this.clientes = new ArrayList<>();
    }

    public Cliente getClienteActual() {
        if (clienteActual.isEmpty()) {
            System.out.println("Cliente no encontrado");
            return null;
        }
        return clienteActual.get();
    }

    public void registrarCliente(String nombre, String apellido, String contrasenia, String direccion, String correo) {
        for (Cliente cliente : clientes) {
            if ( cliente.getNombre().equalsIgnoreCase(nombre) && cliente.getHashContrasenia() == contrasenia.hashCode()) {
                System.out.println("Cliente ya registrado");
                return;
            }
        }
        this.clientes.add(new Cliente(nombre, apellido, contrasenia, direccion, correo));
    }

    public boolean iniciarSesion(String nombre, String contrasenia) {
        if (this.clienteActual.isPresent()) {
            System.out.println("Primero cierra la sesion actual.");
            return false;
        }
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombre) && cliente.getHashContrasenia() == contrasenia.hashCode()) {
                this.clienteActual = Optional.of(cliente);
                System.out.println("Se inicia la sesion.");
                return true;
            }
        }
        System.out.println("Primero registrate.");
        return false;
    }

    public boolean cerrarSesion() {
        if (this.clienteActual.isPresent()) {
            this.clienteActual = Optional.empty();
            System.out.println("Se cierra la sesion.");
            return false;
        }
        System.out.println("Primero cierra la sesion.");
        return true;
    }







}
