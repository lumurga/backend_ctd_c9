package com.backend.futbol.entity;

import javax.persistence.*;

@Entity
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Puesto puesto;
    private int numero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipo_id")//tabla hija - dueña de la relacion
    private Equipo equipo;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "director_tecnico_id")
    private DirectorTecnico tecnico;

    public Jugador() {
    }

    public Jugador(Puesto puesto, int numero, Equipo equipo, DirectorTecnico directorTecnico) {
        this.puesto = puesto;
        this.numero = numero;
        this.equipo = equipo;
        this.tecnico = directorTecnico;

    }

    public Long getId() {
        return id;
    }


    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public DirectorTecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(DirectorTecnico directorTecnico) {
        this.tecnico = directorTecnico;
    }
}
