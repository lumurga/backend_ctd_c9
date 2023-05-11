package com.backend;

public class ManejadorGerencial extends ManejadorMail{
    @Override
    public String procesarMail(Mail mail) {
        System.out.println("Gerencia trabajando...");
        if (mail.getAsunto().equalsIgnoreCase("gerencia") || mail.getDestino().equals("gerencia@colmena.com")){
            return "Procesando el mail...";
        } else {
            return getSiguienteManejador().procesarMail(mail);
        }
    }
}
