package com.backend.integradora.mesas;


import org.apache.log4j.Logger;

import java.util.Collections;

public class AppTest {
    public static void main(String[] args) {
        Logger LOGGER = Logger.getLogger(AppTest.class);
        App app = new App();
        try{
            app.calcularPromedio();

        } catch (Exception e){
            LOGGER.error(e.getMessage());
        }
        app.agregaEntero(59);
        app.agregaEntero(4);
        app.agregaEntero(45);
        app.agregaEntero(15);
        app.agregaEntero(3);
        app.agregaEntero(21);
        app.agregaEntero(22);
        app.agregaEntero(23);
        app.agregaEntero(14);
        app.agregaEntero(10);
        app.agregaEntero(10);
        LOGGER.info("El valor minimo en la lista es de " + Collections.min(app.getEnteros()));
        LOGGER.info("El valor maximo en la lista es de " + Collections.max(app.getEnteros()));

    }
}
