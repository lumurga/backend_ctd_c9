package com.backend;

public class LiquidadorContratado extends LiquidadorSueldo{


    @Override
    protected double calcularSueldo(Empleado empleado) {
        double sueldo = 0;

        if(empleado instanceof EmpleadoContratado emp){
            //una vez que confirme que el empleado que llega por parametro es EmpleadoContratado, lo casteo a ese tipo de dato
            sueldo = emp.getCantHoras() * emp.getValorHora();
        }
        return sueldo;
    }

    @Override
    protected String emitirRecibo(Empleado empleado) {
        return "La liquidacion es un archivo impreso";
    }
}
