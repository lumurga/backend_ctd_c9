package com.backend.mesas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bosque {
    private List<Arbol> arboles;

    public Bosque() {
        arboles = new ArrayList<>();
    }

    public List<Arbol> getArboles() {
        return arboles;
    }

    public void setArboles(List<Arbol> arboles) {
        this.arboles = arboles;
    }

    public void plantarArbol(Arbol arbol){
        if(arbol != null){
            arboles.add(arbol);
            System.out.println("🌳 Arbol de tipo " + arbol.getTipo() + " plantado en el bosque! 🌲🌳🌲");
        } else {
            System.out.println("Primero tenes que crear el arbol para poder plantarlo 🌱");
        }
    }

    public void plantarHastaMorir(int cantidad){
        List<String> tipos = Arrays.asList("Ornamental", "Floral", "Frutal");
        for (String tipo : tipos){
            for(int i = 0; i < cantidad; i++){
                arboles.add(ArbolFactory.obtenerArbol(tipo));
            }
        }
    }

    public void cantidadDeArbolesPorTipo(){
        int frutales = (int) arboles.stream().filter(a -> a.getTipo().equals("Frutal")).count();
        int ornamentales = (int) arboles.stream().filter(a -> a.getTipo().equals("Ornamental")).count();
        int florales = (int) arboles.stream().filter(a -> a.getTipo().equals("Floral")).count();
        System.out.println("Cantidad de arboles frutales plantados 🍐 " + frutales);
        System.out.println("Cantidad de arboles ornamentales plantados 🌲 " + ornamentales);
        System.out.println("Cantidad de arboles florales plantados 🌺 " + florales);
    }


    public void memoriaUsada(){
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memoria usada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));
    }

}
