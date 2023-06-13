package com.backend.clase31.entity;

import javax.persistence.*;

@Entity
@Table(name = "TABLA_MOVIMIENTOS")
public class Movimiento {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO) - por default numerico o Unique identifier
    //@GeneratedValue(strategy = GenerationType.SEQUENCE) - usa una secuencia que puede customizarse
    //@GeneratedValue(strategy = GenerationType.TABLE) - usa una tabla para guardar
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AutoIncrement
    @Column(name = "ID")
    private Long id;
    @Column(name = "DESC")
    private String descripcion;
    @Column(name = "MONT")
    private double monto;

    //Constructor vacio, constructor sin id, getters y setters de todo menos id

    public Movimiento() {
    }

    public Movimiento(String descripcion, double monto) {
        this.descripcion = descripcion;
        this.monto = monto;
    }

    public Long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
