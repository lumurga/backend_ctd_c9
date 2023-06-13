package com.backend.clase32.service.impl;

import com.backend.clase32.entity.Producto;
import com.backend.clase32.repository.IProductoRepository;
import com.backend.clase32.service.IProductoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductoService.class);
    private final IProductoRepository productoRepository;

    @Autowired
    public ProductoService(IProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        Producto productoGuardado = productoRepository.save(producto);
        LOGGER.info("El producto ha sido registrado: {}", productoGuardado);
        return productoGuardado;
    }

    @Override
    public List<Producto> listarProductos() {
        List<Producto> productos = productoRepository.findAll();
        LOGGER.info("Listado de todos los productos: {}", productos);
        return productos;
    }

    @Override
    public Producto buscarPorId(Long id) {
        Producto productoBuscado = productoRepository.findById(id).orElse(null);
        if(productoBuscado != null) LOGGER.info("Producto encontrado: {}", productoBuscado);
        else LOGGER.info("El producto no se ha encontrado en la base de datos");
        return productoBuscado;
    }

    @Override
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}
