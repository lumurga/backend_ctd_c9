package com.backend.clase;

public class ApiProducto {
    public static int calcularDescuentoPorProducto(Producto producto){
        return producto.getTipo().equalsIgnoreCase("latas") ? 10 : 0;
    }
}
