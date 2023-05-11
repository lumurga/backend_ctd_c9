package com.backend.mesas;

public class PreparadorInfantil implements PreparadorMenu{
    @Override
    public String armar(Menu menu) {
        return "1 - Preparar ingredientes. \n2 - Agregar juguetes. \n3 - Cocinar";
    }

    @Override
    public double calcularPrecio(Menu menu) {
        double precio = 0;
        if(menu instanceof MenuInfantil menuInfantil){
            precio = menuInfantil.getPrecioBase() + (menuInfantil.getJuguetes() * 3);
        }

        return precio;

    }
}
