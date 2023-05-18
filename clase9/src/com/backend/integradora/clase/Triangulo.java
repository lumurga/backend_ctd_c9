package com.backend.integradora.clase;

public class Triangulo {
    private String color;
    private int tamanio;

    public Triangulo(String color, int tamanio) {
        this.color = color;
        this.tamanio = tamanio;
    }

    public String getColor() {
        return color;
    }

    public int getTamanio() {
        return tamanio;
    }

    @Override
    public String toString(){
        return "-- Triangulo --" + "\nColor: " + color + "\nTamanio: " + tamanio;
    }
}
