package com.backend.clase.test;

import com.backend.clase.Persona;
import com.backend.clase.Vacunatorio;
import com.backend.clase.VacunatorioProxy;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class VacunatorioTest {

    @Test
    public void deberiaVacunarPersona(){
        Persona persona = new Persona("Joel", "2489875486", "Antitetanica", LocalDate.of(2023, 05, 11));
        Vacunatorio vacunatorio = new VacunatorioProxy();

        String rtaEsperada = "Se ha registrado a la persona DNI numero 2489875486, vacunada con Antitetanica el dia 2023-05-11";

        String rtaObtenida = vacunatorio.vacunar(persona);
        assertEquals(rtaEsperada, rtaObtenida);

    }

}