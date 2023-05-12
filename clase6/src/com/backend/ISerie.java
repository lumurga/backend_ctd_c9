package com.backend;

public interface ISerie {
    //interfaz ISerie que define metodo obtenerSerie, recibe el nombre de la pelicula y devuelve un string
    String obtenerSerie(String nombreSerie) throws SerieNoHabilitadaException;

}
