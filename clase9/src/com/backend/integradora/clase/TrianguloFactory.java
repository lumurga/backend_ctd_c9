package com.backend.integradora.clase;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class TrianguloFactory {
    private static Map<String, Triangulo> trianguloMap = new HashMap<>();
    private static final Logger LOGGER = Logger.getLogger(TrianguloFactory.class);

    public static Triangulo obtenerTriangulo(String color, int tamanio){

        Triangulo triangulo = trianguloMap.get(color);

        if(triangulo == null){
            triangulo = new Triangulo(color, tamanio);
            trianguloMap.put(color, triangulo);
            if(LOGGER.isInfoEnabled()) LOGGER.info("Triangulo creado: " + triangulo);

        } else {
            LOGGER.info("Triangulo encontrado: " + triangulo);
        }

        return triangulo;

    }

}
