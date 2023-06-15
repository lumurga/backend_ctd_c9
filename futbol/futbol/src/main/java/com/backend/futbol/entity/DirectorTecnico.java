package com.backend.futbol.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "DIRECTORES_TECNICOS")
public class DirectorTecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int edad;

    @OneToMany(mappedBy = "tecnico", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Jugador> jugadores = new HashSet<>();

    public DirectorTecnico() {
    }

    public DirectorTecnico(String nombre, int edad, Set<Jugador> jugadores) {
        this.nombre = nombre;
        this.edad = edad;
        this.jugadores = jugadores;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Set<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(Set<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
}
