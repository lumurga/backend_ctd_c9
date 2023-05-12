package com.backend;

public class Main {
    public static void main(String[] args) {
        ISerie proxy = new SerieProxy();
        try{
            System.out.println(proxy.obtenerSerie("Loki"));
            System.out.println(proxy.obtenerSerie("Gambito de Dama"));
            System.out.println(proxy.obtenerSerie("Stranger things"));
            System.out.println(proxy.obtenerSerie("Elite"));
            System.out.println(proxy.obtenerSerie("Green arrow"));

        } catch (SerieNoHabilitadaException e){
            System.out.println(e);
        }
    }
}
