package com.backend.mesas;

public class Main {
    public static void main(String[] args) {

        Arbol arbolFrutal = ArbolFactory.obtenerArbol("Frutal");
        arbolFrutal.setAlto(500);
        arbolFrutal.setAncho(300);
        arbolFrutal.setColor("Rojo");

        Arbol arbolOrnamental = ArbolFactory.obtenerArbol("Ornamental");
        arbolOrnamental.setAlto(200);
        arbolOrnamental.setAncho(400);
        arbolOrnamental.setColor("Verde");

        Arbol arbolFloral = ArbolFactory.obtenerArbol("Floral");
        arbolFloral.setAlto(100);
        arbolFloral.setAncho(200);
        arbolFloral.setColor("Celeste");

        System.out.println("🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱");
        Bosque bosque = new Bosque();
        bosque.plantarHastaMorir(1000000);
        bosque.cantidadDeArbolesPorTipo();
        bosque.memoriaUsada();

    }
}
