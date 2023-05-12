package com.backend.clase;

import java.time.LocalDate;

public class VacunatorioProxy implements Vacunatorio{

    private VacunatorioService vacunatorioService;

    @Override
    public String vacunar(Persona persona) {
        //controlar fecha
        String mensaje = "La fecha no se corresponde con la que tiene asignada";
        if(comprobarFecha(persona.getFechaAsignada())){
            //si la fecha es correcta
            vacunatorioService = new VacunatorioService();
            mensaje = vacunatorioService.vacunar(persona);
        }
        return mensaje;
    }

    private boolean comprobarFecha(LocalDate fechaAsignada){
        LocalDate hoy = LocalDate.now();
        return !fechaAsignada.isBefore(hoy);
    }
}
