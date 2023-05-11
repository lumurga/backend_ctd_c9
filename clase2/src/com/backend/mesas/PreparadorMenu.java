package com.backend.mesas;

public interface PreparadorMenu {
    //a partir de java 8 las interfaces admiten otros metodos que no sean abstractos, por ej default permite darle implementacion
    //este es el metodo template
    default String prepararMenu(Menu menu){
        String rta = "Iniciando preparacion...\n";
        //paso 1 preparar
        rta = rta.concat(armar(menu));
        //paso 2 calcular precio
        rta = rta.concat("\nEl precio es: $" + calcularPrecio(menu));
        return rta;
    }

    String armar(Menu menu);
    double calcularPrecio(Menu menu);

}
