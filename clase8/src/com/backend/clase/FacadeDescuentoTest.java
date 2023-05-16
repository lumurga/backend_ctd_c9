package com.backend.clase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FacadeDescuentoTest {

    FacadeDescuento facadeDescuento = new FacadeDescuento();

    @Test
    public void deberiaCalcular25(){
        Tarjeta tarjeta = new Tarjeta("link bank", "5746343658");
        Producto producto = new Producto("choclo", "latas");
        int rtaEsperada = 25;
        int rtaObtenida = facadeDescuento.calcularDescuento(15, tarjeta, producto);
        assertEquals(rtaEsperada, rtaObtenida);

    }

    @Test
    public void deberiaCalcular45(){
        Tarjeta tarjeta = new Tarjeta("star bank", "5746343658");
        Producto producto = new Producto("atun", "latas");
        int rtaEsperada = 45;
        int rtaObtenida = facadeDescuento.calcularDescuento(13, tarjeta, producto);
        assertEquals(rtaEsperada, rtaObtenida);
    }

}