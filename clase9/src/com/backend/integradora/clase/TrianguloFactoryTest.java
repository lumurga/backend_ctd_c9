package com.backend.integradora.clase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrianguloFactoryTest {


    @Test
    public void deberianTenerElMismoColorYTamanio(){
        Triangulo t1 = TrianguloFactory.obtenerTriangulo("verde", 1);
        Triangulo t2 = TrianguloFactory.obtenerTriangulo("verde", 2);

        assertEquals(t1.getTamanio(), t2.getTamanio());
        assertNotEquals(2, t2.getTamanio());

    }

}