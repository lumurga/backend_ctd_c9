package com.backend.clase;

public class ApiTarjeta {
    public static int calcularDescuentoPorTarjeta(Tarjeta tarjeta){
        return tarjeta.getBanco().equalsIgnoreCase("star bank") ? 20 : 0;
    }
}
