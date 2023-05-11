package com.backend.clase.test;

import com.backend.clase.Grupo;
import com.backend.clase.Persona;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrupoTest {
    
    private final Grupo grupo = new Grupo();

    @Test
    public void deberianAgregarseDosPersonas(){
        Persona persona1 = new Persona("Juan", 20);
        Persona persona2 = new Persona("Pedro", 20);
        Persona persona3 = new Persona("Ana", 20);
        Persona persona4 = new Persona("Julian", 20);
        Persona persona5 = new Persona("Luz", 20);
        grupo.agregarPersona(persona1);
        grupo.agregarPersona(persona2);
        grupo.agregarPersona(persona3);
        grupo.agregarPersona(persona4);
        grupo.agregarPersona(persona5);

        assertEquals(2, grupo.getAdmitidos().size());

    }
}