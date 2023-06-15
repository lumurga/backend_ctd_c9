package com.backend.futbol.service;

import com.backend.futbol.entity.DirectorTecnico;
import com.backend.futbol.entity.Jugador;

public interface IDirectorTecnicoService {
    DirectorTecnico crearDt(DirectorTecnico directorTecnico);

    void agregarJugador(Jugador jugador, DirectorTecnico directorTecnico);
}
