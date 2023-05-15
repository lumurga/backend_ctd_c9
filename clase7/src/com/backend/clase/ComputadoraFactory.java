package com.backend.clase;

import java.util.HashMap;
import java.util.Map;

public class ComputadoraFactory {
    private static Map<String, Computadora> computadorasLigeras = new HashMap<>();

    public Computadora obtenerComputadora(int ram, int disco){
        //definir la key, que no es = al id
        String key = "key:" + ram + ":" + disco;
        System.out.println(key);
        //verificar si ya esta creada o no
        if(!computadorasLigeras.containsKey(key)){
            //creamos la compu y la agregamos con su key a la coleccion
            computadorasLigeras.put(key, new Computadora(ram, disco));
            System.out.println("Computadora creada");
        } else {
            System.out.println("Computadora encontrada");
        }
        return computadorasLigeras.get(key);
    }
}
