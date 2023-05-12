package com.backend;

public class SerieProxy implements ISerie {
    //SerieProxy tiene un atributo cantidad de vistas, mas el servicio
    private SerieService serieService;
    private int cantVistasSemanales;

    @Override
    public String obtenerSerie(String nombreSerie) throws SerieNoHabilitadaException{
        if(cantVistasSemanales > 4){
            throw new SerieNoHabilitadaException(nombreSerie + " excede la cantidad de reproducciones permitidas por semana");
        }
        serieService = new SerieService();
        cantVistasSemanales++;
        return serieService.obtenerSerie(nombreSerie);
    }


}
