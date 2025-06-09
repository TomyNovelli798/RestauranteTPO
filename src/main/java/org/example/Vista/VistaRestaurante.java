package org.example.Vista;

import org.example.Controller.Restaurante;
import org.example.Model.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VistaRestaurante {
    private final Scanner scanner = new Scanner(System.in);
    private final Restaurante controlador;

    public VistaRestaurante(Restaurante restaurante) {
        this.controlador = restaurante;
    }

    public void iniciar() {
        System.out.println("=== Bienvenido al Restaurante ===");

        controlador.getServiceUsuario().registrarUsuario("Cliente", "Lucia", "Pérez", "1234", "lucia@email.com");
        controlador.getServiceUsuario().registrarUsuario("001", "Mariana", "López", "1111", "pepe@email.com");
        controlador.getServiceUsuario().registrarUsuario("002", "Carlos", "García", "2222", "juan@email.com");
        controlador.getServiceUsuario().registrarUsuario("003", "Sofía", "Martínez", "3333", "carlos@email.com");

        // Simular inicio de sesión
        System.out.println("Ingrese nombre de usuario:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese contraseña:");
        String hash = scanner.nextLine();

        boolean sesionIniciada = controlador.getServiceUsuario().iniciarSesion(nombre, hash);
        if (!sesionIniciada) {
            System.out.println("Error al iniciar sesión");
            return;
        }

        Usuario actual = controlador.getServiceUsuario().getUsuarioActual();
        System.out.println("Sesión iniciada como: " + actual.getNombre());

        if (actual instanceof Cliente clienteActivo) {
            manejarCliente(clienteActivo);
        } else if (actual instanceof Empleado empleadoActivo) {
            manejarEmpleado(empleadoActivo);
        }
    }

    private void manejarCliente(Cliente cliente) {
        Map<String, Integer> productosSolicitados = new HashMap<>();

        boolean salir = false;
        while (!salir) {
            System.out.println("1. Calcular pedido\n2. Hacer pedido\n3. Pagar pedido\n4. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            Map<String, Integer> productos = new HashMap<>();
            productosSolicitados.put("Empanada", 2);
            productosSolicitados.put("Bruschetta", 1);
            productosSolicitados.put("Coca-Cola", 3);
            productosSolicitados.put("Limonada", 1);
            productosSolicitados.put("Milanesa", 2);
            productosSolicitados.put("Pasta", 1);
            productosSolicitados.put("Helado", 2);
            productosSolicitados.put("Flan", 1);

            String horario = "2025-06-08 19:15";



            switch (opcion) {
                case 1 -> {
                    productosSolicitados.clear();
                    System.out.println("Ingrese productos y cantidades. Escriba 'fin' para terminar.");
                    while (true) {
                        System.out.print("Producto: ");
                        String nombre = scanner.nextLine();
                        if (nombre.equalsIgnoreCase("fin")) break;
                        System.out.print("Cantidad: ");
                        int cantidad = scanner.nextInt();
                        scanner.nextLine();
                        productosSolicitados.put(nombre, cantidad);
                    }

                    float total = controlador.calcularPedido(productos);
                    System.out.println("El precio es: " + total);
                }
                case 2 -> {
                    System.out.print("Ingrese cupon (o ninguno): ");
                    String cupon = scanner.nextLine();
                    System.out.println("Ingrese la plataforma en la que realiza el pedido: (TOTEM/APP) ");
                    String plataforma = scanner.nextLine();
                    System.out.println("Ingrese la modalidad de la entrega: (Delivery/Local)");
                    String modalidad = scanner.nextLine();
                    controlador.hacerPedido(cupon, productos, horario, plataforma, modalidad);
                }
                case 3 -> {
                    String metodo;
                    String tipoTarjeta;
                    while(true) {
                        System.out.println("Ingresa la estrategia de pago que utiliza: (Tarjeta/Efectivo/GooglePay/MercadoPago)");
                        metodo = scanner.nextLine().toLowerCase();

                        if (metodo.equalsIgnoreCase("Tarjeta")) {
                            System.out.println("Se seleccionó pago con tarjeta. Que tarjeta desea usar?: (Credito / Debito)");
                            tipoTarjeta = scanner.nextLine().toLowerCase();
                            if (tipoTarjeta.equalsIgnoreCase("debito")) {
                                System.out.println("Se seleccionó pago con débito.");
                                break;
                            } else if (tipoTarjeta.equalsIgnoreCase("credito")) {
                                System.out.println("Se seleccionó pago con crédito.");
                                break;
                            }
                        } else if (metodo.equalsIgnoreCase("Efectivo")) {
                            System.out.println("Se seleccionó pago con Efectivo, disfruta tu pedido con 10% de descuento!!");
                            break;
                        } else if (metodo.equalsIgnoreCase("GooglePay")) {
                            System.out.println("Se seleccionó pago con GooglePay.");
                            break;
                        } else if (metodo.equalsIgnoreCase("MercadoPago")) {
                            System.out.println("Se seleccionó pago con MercadoPago.");
                            break;
                        } else {
                            System.out.println("Método de pago no reconocido.");
                        }
                    }

                    Pedido pedido = controlador.getServicePedido().getUltimoPedido();
                    float total = controlador.calcularPedido(productos);


                    boolean pagado = controlador.pagoPedido(total, metodo);
                    System.out.println("¿Pago exitoso?: " + pagado);
                }
                case 4 -> salir = true;
                default -> System.out.println("Opción inválida");
            }
        }
    }

    private void manejarEmpleado(Empleado empleado) {
        boolean salir = false;
        while (!salir) {
            System.out.println("1. Cambiar estado del pedido\n2. Enviar notificación\n3. Generar informe (solo admin)\n4. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> {
                    Pedido pedido = controlador.getServicePedido().getUltimoPedido();
                    controlador.cambiarEstado(pedido);
                }
                case 2 -> {
                    Pedido pedido = controlador.getServicePedido().getUltimoPedido();
                    Usuario destinatario = pedido.getCliente();
                    controlador.notificacionPedido(pedido, destinatario);
                }
                case 3 -> {
                    if (empleado instanceof Administrativo admin) {
                        controlador.generarInforme(admin);
                    } else {
                        System.out.println("Solo un administrador puede generar informe.");
                    }
                }
                case 4 -> salir = true;
                default -> System.out.println("Opción inválida");
            }
        }
    }
}
