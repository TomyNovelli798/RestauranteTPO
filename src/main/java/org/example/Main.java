package org.example;

import org.example.Controller.Restaurante;
import org.example.Model.*;
import org.example.Vista.VistaRestaurante;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Componente menuGeneral = new MenuEspecifico("Menu General");

        MenuEspecifico menuEntradas = new MenuEspecifico("Entradas");
        MenuEspecifico menuBebidas = new MenuEspecifico("Bebidas");
        MenuEspecifico menuPlatos = new MenuEspecifico("Platos");
        MenuEspecifico menuPostres = new MenuEspecifico("Postres");

        // Entradas
        Producto empanada = new Producto("Empanada", "Empanada de carne picada", 500F, false, (short) 2);
        Producto bruschetta = new Producto("Bruschetta", "Pan tostado con tomate y albahaca", 450F, false, (short) 3);
        menuEntradas.añadir(empanada);
        menuEntradas.añadir(bruschetta);

        // Bebidas
        Producto cocaCola = new Producto("Coca-Cola", "Bebida gaseosa 350ml", 300F, false, (short) 1);
        Producto limonada = new Producto("Limonada", "Limonada casera con menta", 350F, false, (short) 2);
        menuBebidas.añadir(cocaCola);
        menuBebidas.añadir(limonada);

        // Platos
        Producto milanesa = new Producto("Milanesa", "Milanesa con papas fritas", 1200F, true, (short) 15);
        Producto pasta = new Producto("Pasta", "Fideos con salsa bolognesa", 1100F, false, (short) 20) ;
        menuPlatos.añadir(milanesa);
        menuPlatos.añadir(pasta);

        // Postres
        Producto helado = new Producto("Helado", "Helado de vainilla con salsa de chocolate", 400F, true, (short) 3);
        Producto flan = new Producto("Flan", "Flan casero con dulce de leche", 380F, true, (short) 4);
        menuPostres.añadir(helado);
        menuPostres.añadir(flan);

        // Agregar los submenús al menú general
        menuGeneral.añadir(menuEntradas);
        menuGeneral.añadir(menuBebidas);
        menuGeneral.añadir(menuPlatos);
        menuGeneral.añadir(menuPostres);

        Restaurante restaurante = new Restaurante(menuGeneral);


        // Iniciar vista
        VistaRestaurante vista = new VistaRestaurante(restaurante);
        vista.iniciar();
    }
}