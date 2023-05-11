package com.backend.mesas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraDeAreaTest {
    @Test
    public void deberiaCalcularElAreaDeCirculo(){
        String rtaEsperada = "El area del circulo es igual a 314.1592653589793";
        String rtaObtenida = CalculadoraDeArea.areaCirculo(10);
        assertEquals(rtaEsperada, rtaObtenida);
    }

    @Test
    public void deberiaCalcularElAreaDeCuadrado(){
        String rtaEsperada = "El area del cuadrado es igual a 16.0";
        String rtaObtenida = CalculadoraDeArea.areaCuadrado(4);
        assertEquals(rtaEsperada, rtaObtenida);
        assertNotEquals("El area del cuadrado es igual a 20", rtaObtenida);
    }

}