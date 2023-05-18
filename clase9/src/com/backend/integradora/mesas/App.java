package com.backend.integradora.mesas;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class App {
    private static final Logger LOGGER = Logger.getLogger(App.class);
    private List<Integer> enteros;

    public App() {
        enteros = new ArrayList<>();
    }
    public void agregaEntero(Integer entero){
        enteros.add(entero);
        int size = enteros.size();
        if(size > 5) LOGGER.info("La lista de enteros tiene mas de 5 elementos. Cantidad total de elementos: " + size + "\n" + enteros);
        if(size > 10) LOGGER.info("La lista de enteros tiene mas de 10 elementos. Cantidad total de elementos: " + size + "\n" + enteros);
    }

    public double calcularPromedio() throws Exception{
        if(enteros.isEmpty()){
            throw new Exception("La lista se encuentra vacía");
        } else {
            int total = 0;
            for (Integer entero : enteros){
                total += entero;
            }
            double promedio = total/enteros.size();
            LOGGER.info("El promedio es de " + promedio);
            return promedio;
        }
    }

    public List<Integer> getEnteros() {
        return enteros;
    }
}
