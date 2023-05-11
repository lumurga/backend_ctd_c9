package com.backend;

import java.util.logging.Handler;

public class CompruebaMail {
    //se encarga de iniciar el proceso, por ende la cadena
    private ManejadorMail manejadorInicial;

    public CompruebaMail() {
        //definimos el orden de la cadena
        //inicio cadena
        manejadorInicial = new ManejadorGerencial();
        //segundo eslabon
        ManejadorMail tecnico = new ManejadorTecnico();
        manejadorInicial.setSiguienteManejador(tecnico);
        //tercer eslabon
        ManejadorMail comercial = new ManejadorComercial();
        tecnico.setSiguienteManejador(comercial);
        //ultimo
        ManejadorMail spam = new ManejadorSpam();
        comercial.setSiguienteManejador(spam);
    }

    public String procesarMail(Mail mail){
        return manejadorInicial.procesarMail(mail);
    }
}
