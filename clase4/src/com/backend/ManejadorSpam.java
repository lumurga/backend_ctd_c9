package com.backend;

public class ManejadorSpam extends ManejadorMail{
    @Override
    public String procesarMail(Mail mail) {
        System.out.println("Spameando...");
        return "SPAM";
    }
}
