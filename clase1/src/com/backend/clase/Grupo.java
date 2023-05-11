package com.backend.clase;

import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private List<Persona> admitidos;// = new ArrayList<>();

    public Grupo() {
        admitidos = new ArrayList<>();
    }

    //sobrecarga del contructor
    public Grupo(List<Persona> admitidos) {
        this.admitidos = admitidos;
    }

    public List<Persona> getAdmitidos() {
        return admitidos;
    }

    public void setAdmitidos(List<Persona> admitidos) {
        this.admitidos = admitidos;
    }

    public void agregarPersona(Persona persona){
        if(persona.getNombre().length() >= 5 && persona.getEdad() >= 18){
          admitidos.add(persona);
        } else {
            System.out.println("No es posible agregar a " + persona.getNombre() + " al grupo");
        }


    }


}
