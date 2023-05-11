package com.backend;

public class Mail {
    private String origen;
    private String destino;
    private String asunto;

    public Mail(String origen, String destino, String asunto) {
        this.origen = origen;
        this.destino = destino;
        this.asunto = asunto;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
}
