package com.backend.clase;

public abstract class LiquidadorSueldo {

    public String liquidarSueldo(Empleado empleado){
        String respuesta = "La liquidacion no pudo ser calculada";

        //calcular sueldo segun tipo empleado
        double sueldo = calcularSueldo(empleado);

        if(sueldo > 0){
            //emitir recibo
            String recibo = emitirRecibo(empleado);
            respuesta = recibo + ". Sueldo a liquidar $" + sueldo;
            //depositar
            System.out.println(depositar(empleado));
        }

        return respuesta;
    }

    protected abstract double calcularSueldo(Empleado empleado);
    protected abstract String emitirRecibo(Empleado empleado);

    private String depositar(Empleado empleado){
        return "Orden de deposito en la cuenta: " + empleado.getNumeroCuenta();
    }


}
