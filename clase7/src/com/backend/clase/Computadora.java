package com.backend.clase;

public class Computadora {

    private String id;
    private int ram;
    private int disco;
    private static int contador;

    public Computadora(int ram, int disco){
        this.ram = ram;
        this.disco = disco;
        this.id = "AR"+ram+"-"+disco;
        contador++;
        System.out.println("Existencias: " + contador);
    }

    public String getId() {
        return id;
    }

    public int getRam() {
        return ram;
    }

    public int getDisco() {
        return disco;
    }

    public static int getContador() {
        return contador;
    }

    @Override
    public String toString(){
        return "Computadora: [" + id + "]";
    }
}
