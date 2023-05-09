package com.backend.test;

import com.backend.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LiquidadorSueldoTest {
    LiquidadorSueldo liquidadorSueldo;


    @Test
    public void deberiaLiquidarElSueldoEmpleadoEfectivo(){
        liquidadorSueldo = new LiquidadorEfectivo();
        Empleado empleado = new EmpleadoEfectivo("Martin", "Martini", "CA-65176878777", 400000, 10000, 1000);

        String rtaEsperada = "La liquidacion es un archivo digital. Sueldo a liquidar $409000.0";
        String rtaObtenida = liquidadorSueldo.liquidarSueldo(empleado);

        assertEquals(rtaEsperada, rtaObtenida);
    }

    @Test
    public void deberiaLiquidarElSueldoEmpleadoContratado(){
        liquidadorSueldo = new LiquidadorContratado();
        Empleado empleado = new EmpleadoContratado("Martin", "Martini", "CA-65176878777", 120, 2000);

        String rtaEsperada = "La liquidacion es un archivo impreso. Sueldo a liquidar $240000.0";
        String rtaObtenida = liquidadorSueldo.liquidarSueldo(empleado);

        assertEquals(rtaEsperada, rtaObtenida);
    }

}