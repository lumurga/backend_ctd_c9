package com.backend.mesas;

import java.util.HashMap;
import java.util.Map;

public class ArbolFactory {
    private static Map<String, Arbol> arbolHashMap = new HashMap<>();

    public static Arbol obtenerArbol(String tipo){
        Arbol arbol = arbolHashMap.get(tipo);
        if(arbol == null){
            arbol = new Arbol(tipo);
            arbolHashMap.put(tipo, arbol);
            System.out.println("🌳 creando un arbol de tipo " + tipo);
        }
        return arbol;
    }

    public static Map<String, Arbol> getArbolHashMap() {
        return arbolHashMap;
    }

    public static void setArbolHashMap(Map<String, Arbol> arbolHashMap) {
        ArbolFactory.arbolHashMap = arbolHashMap;
    }
}
