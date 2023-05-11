package com.backend;

public class ManejadorComercial extends ManejadorMail{
    @Override
    public String procesarMail(Mail mail) {
        System.out.println("Area comercial trabajando...");
        if (mail.getAsunto().equalsIgnoreCase("comercial") || mail.getDestino().equals("comercial@colmena.com")){
            return "Procesando el mail...";
        } else {
            return getSiguienteManejador().procesarMail(mail);
        }
    }
}
