package com.backend.mesas.test;

import com.backend.mesas.Descarga;
import com.backend.mesas.ProxyDescarga;
import com.backend.mesas.TipoUsuario;
import com.backend.mesas.Usuario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DescargaTest {

    @Test
    public void deberiaIniciarDescarga(){
        Usuario us1 = new Usuario(1, TipoUsuario.PREMIUM);
        Descarga proxy = new ProxyDescarga();

        String rtaEsperada = "Iniciando descarga para el usuario 1";
        String rtaObtenida = proxy.descargarCancion(us1);

        assertEquals(rtaEsperada, rtaObtenida);

    }

    @Test
    public void noDeberiaIniciarDescarga(){
        Usuario us2 = new Usuario(002, TipoUsuario.FREE);
        Descarga proxy = new ProxyDescarga();

        String rtaEsperada = "Iniciando descarga para el usuario 002";
        String rtaObtenida = proxy.descargarCancion(us2);

        assertNotEquals(rtaEsperada, rtaObtenida);
    }
}