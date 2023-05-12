package com.backend.test;


import com.backend.ISerie;
import com.backend.SerieNoHabilitadaException;
import com.backend.SerieProxy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SerieProxyTest {
    ISerie proxy = new SerieProxy();

    @Test
    public void deberiaPermitirReproducirSerie(){
        try{
            String rtaObtenida = proxy.obtenerSerie("Dexter");
            assertNotNull(rtaObtenida);
            assertEquals("www.dexter.com", rtaObtenida);

        }catch (SerieNoHabilitadaException e){
            assertNotEquals("Dexter excede la cantidad de reproducciones permitidas por semana", e.getMessage());
        }
    }

    @Test
    public void noDeberiaPermitirReproducirSerie(){
        try{
            proxy.obtenerSerie("Los Simpsons");
            proxy.obtenerSerie("Daredevil");
            proxy.obtenerSerie("Los Soprano");
            proxy.obtenerSerie("Friends");
            proxy.obtenerSerie("Breaking Bad");
            proxy.obtenerSerie("Dexter");

        } catch (SerieNoHabilitadaException e){
            assertEquals("Dexter excede la cantidad de reproducciones permitidas por semana", e.getMessage());
        }
    }

}