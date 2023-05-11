package com.backend;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompruebaMailTest {

    CompruebaMail compruebaMail = new CompruebaMail();

    @Test
    public void deberiaPasarASpam(){
        Mail mail = new Mail("lu@gmail.com", "sarasa@gmail.com", "Hola");
        String rtaEsperada = "SPAM";
        String rtaObtenida = compruebaMail.procesarMail(mail);

        assertEquals(rtaEsperada, rtaObtenida);

    }


}