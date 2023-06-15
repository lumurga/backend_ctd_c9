package com.backend.futbol.service;

import com.backend.futbol.entity.Jugador;

import java.util.Set;

public interface IJugadorService {
    Set<Jugador> listarJugadoresPorTecnico(String nombreDt);
}
