package com.backend;

public class ManejadorTecnico extends ManejadorMail{
    @Override
    public String procesarMail(Mail mail) {
        System.out.println("Area tecnica trabajando...");
        if (mail.getAsunto().equalsIgnoreCase("tecnica") || mail.getDestino().equals("tecnica@colmena.com")){
            return "Procesando el mail...";
        } else {
            return getSiguienteManejador().procesarMail(mail);
        }
    }
}
