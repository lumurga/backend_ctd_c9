package com.backend.mesas;

public class PreparadorClasico implements PreparadorMenu {
    @Override
    public String armar(Menu menu) {
        return "1 - Preparar ingredientes. \n2 - Cocinar";
    }

    @Override
    public double calcularPrecio(Menu menu) {
        return menu.getPrecioBase();
    }
}
