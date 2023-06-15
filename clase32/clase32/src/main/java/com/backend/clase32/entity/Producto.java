package com.backend.clase32.entity;


import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name = "PRODUCTOS")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    //@NotNull
    @Size(min = 10, max = 50, message = "Nombre debe tener entre 10 y 50 caracteres")
    private String nombre;

    //si usamos el primitivo, hibernate lo mapeara como NotNull a menos que indiquemos @Column(nullable = true), si usamos el wrapper (Integer) no, a menos que explicitamente lo indiquemos con @NotNull o @Column(nullable = false)
    private int cantidad;
    private String descripcion;
    



    public Producto() {
    }

    public Producto(String nombre, String descripcion, int cantidad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString(){
        return "Nombre: " + nombre + "- Descripcion: " + descripcion + "- Cantidad: " + cantidad;
    }
}
