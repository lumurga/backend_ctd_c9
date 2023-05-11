package com.backend.mesas;

public class CalculadoraDeArea {
    public static String areaCirculo(double radio){
        String respuesta = "El valor tiene que ser mayor a cero";
        if(radio > 0) respuesta = "El area del circulo es igual a " + (Math.PI * Math.pow(radio, 2));
        return respuesta;
    }

    public static String areaCuadrado(double lado){
        String respuesta = "El valor tiene que ser mayor a cero";
        if(lado > 0) respuesta = "El area del cuadrado es igual a " + Math.pow(lado, 2);
        return respuesta;
    }

}
