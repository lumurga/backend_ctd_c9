package com.backend.clase;

import java.time.LocalDate;

public class VacunatorioService implements Vacunatorio {

    @Override
    public String vacunar(Persona persona) {

        System.out.println("Recibiendo a " + persona.getNombre());
        return "Se ha registrado a la persona DNI numero " + persona.getDni() + ", vacunada con " + persona.getNombreVacuna() + " el dia " + LocalDate.now();
    }
}
