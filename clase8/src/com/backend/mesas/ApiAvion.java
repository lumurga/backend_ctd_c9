package com.backend.mesas;

public class ApiAvion {
    //este servicio se comunicaria con la api que de aviones
    public void buscarVuelos(String fechaIda, String fechaVuelta, String origen, String destino){
        System.out.println("---------------------------------");
        System.out.println("Vuelos encontrados para " + destino + " desde " + origen);
        System.out.println("Fecha ida: " + fechaIda + " - Fecha regreso: " +fechaVuelta);
        System.out.println("---------------------------------");
        System.out.println("Vuelo 1");
        System.out.println("Vuelo 2");
        System.out.println("Vuelo 3");
        System.out.println("\n---------------------------------");
    }
}
