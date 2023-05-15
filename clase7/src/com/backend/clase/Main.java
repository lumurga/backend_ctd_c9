package com.backend.clase;

public class Main {
    public static void main(String[] args) {
        ComputadoraFactory fabrica = new ComputadoraFactory();

        Computadora windows1 = fabrica.obtenerComputadora(2, 128);
        Computadora mac1 = fabrica.obtenerComputadora(16, 500);

        Computadora windows2 = fabrica.obtenerComputadora(2, 128);
        Computadora mac2 = fabrica.obtenerComputadora(16, 500);


        Computadora windows3 = fabrica.obtenerComputadora(2, 128);
        Computadora mac3 = fabrica.obtenerComputadora(16, 500);
        Computadora windows4 = fabrica.obtenerComputadora(4, 500);
        Computadora windows5 = fabrica.obtenerComputadora(4, 500);

        System.out.println("--------------------------------------------------------");

        System.out.println(windows1);
        System.out.println(windows2);
        System.out.println(windows3);
        System.out.println(mac1);
        System.out.println(mac2);
        System.out.println(mac3);


        System.out.println("Compus creadas: " + Computadora.getContador());

    }
}
