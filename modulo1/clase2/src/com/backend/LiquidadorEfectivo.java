package com.backend;

public class LiquidadorEfectivo extends LiquidadorSueldo{
    @Override
    protected double calcularSueldo(Empleado empleado) {
        double sueldo = 0;

        if(empleado instanceof EmpleadoEfectivo emp){
            //una vez que confirme que el empleado que llega por parametro es EmpleadoContratado, lo casteo a ese tipo de dato
            sueldo = emp.getSueldoBase() + emp.getPremio() - emp.getDescuento();
        }
        return sueldo;
    }

    @Override
    protected String emitirRecibo(Empleado empleado) {
        return "La liquidacion es un archivo digital";
    }
}
