package com.backend.clase;

public class FacadeDescuento implements IDescuento{


    //metodo de la fachada
    @Override
    public int calcularDescuento(int cantidad, Tarjeta tarjeta, Producto producto) {
        int descuento = 0;
        descuento += ApiCantidad.calcularDescuentoPorCantidad(cantidad);
        descuento += ApiProducto.calcularDescuentoPorProducto(producto);
        descuento += ApiTarjeta.calcularDescuentoPorTarjeta(tarjeta);
        System.out.println(descuento);
        return descuento;
    }

}
