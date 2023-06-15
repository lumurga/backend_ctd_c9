package com.backend.clase32.controller;

import com.backend.clase32.entity.Producto;
import com.backend.clase32.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    private final IProductoService productoService;

    @Autowired
    public ProductoController(IProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarProducto(@RequestBody Producto producto){
        Producto productoS = productoService.guardarProducto(producto);
        return new ResponseEntity<>(productoS, null, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Producto> listarProductos(){
        return productoService.listarProductos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarProductoPorId(@PathVariable Long id){
        Producto producto = productoService.buscarPorId(id);
        return producto != null ? new ResponseEntity<>(producto, null, HttpStatus.FOUND) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
