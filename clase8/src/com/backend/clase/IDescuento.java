package com.backend.clase;

public interface IDescuento {
    int calcularDescuento(int cantidad, Tarjeta tarjeta, Producto producto);
}
