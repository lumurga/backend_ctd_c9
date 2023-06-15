package com.backend.futbol.service.impl;

import com.backend.futbol.entity.Jugador;
import com.backend.futbol.repository.JugadorRepository;
import com.backend.futbol.service.IJugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class JugadorService implements IJugadorService {

    private final JugadorRepository jugadorRepository;

    @Autowired
    public JugadorService(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    @Override
    public Set<Jugador> listarJugadoresPorTecnico(String nombreDt) {
        return jugadorRepository.listarJugadoresPorTecnico(nombreDt);
    }
}
