package com.backend;

public class SerieNoHabilitadaException extends Exception{
    public SerieNoHabilitadaException() {
    }

    public SerieNoHabilitadaException(String message) {
        super(message);
    }

    @Override
    public String toString(){
        return "Excepcion: " + getClass().getName() + "\nMensaje: "
 + getMessage();
    }
}
