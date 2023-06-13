package com.backend.clase32.service;

import com.backend.clase32.entity.Producto;

import java.util.List;

public interface IProductoService {
    Producto guardarProducto(Producto producto);
    List<Producto> listarProductos();
    Producto buscarPorId(Long id);
    void eliminarProducto(Long id);

}
