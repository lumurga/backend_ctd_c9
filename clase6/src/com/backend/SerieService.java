package com.backend;

import java.util.Locale;

public class SerieService implements ISerie{
    //SerieService implementa ISerie y retorna un string equivalente al link de la serie

    @Override
    public String obtenerSerie(String nombreSerie) {
        return  "www." + nombreSerie.toLowerCase(Locale.ROOT).replace(" ", "-") + ".com";
    }
}
