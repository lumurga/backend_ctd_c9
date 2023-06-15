package com.backend.futbol.service.impl;

import com.backend.futbol.entity.DirectorTecnico;
import com.backend.futbol.entity.Jugador;
import com.backend.futbol.repository.DirectorTecnicoRepository;
import com.backend.futbol.service.IDirectorTecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectorTecnicoService implements IDirectorTecnicoService {

    private DirectorTecnicoRepository directorTecnicoRepository;

    @Autowired
    public DirectorTecnicoService(DirectorTecnicoRepository directorTecnicoRepository) {
        this.directorTecnicoRepository = directorTecnicoRepository;
    }

    @Override
    public DirectorTecnico crearDt(DirectorTecnico directorTecnico) {
        return directorTecnicoRepository.save(directorTecnico);
    }

    @Override
    public void agregarJugador(Jugador jugador, DirectorTecnico directorTecnico) {
        if (!directorTecnicoRepository.existsById(directorTecnico.getId())) {
            directorTecnicoRepository.save(directorTecnico);
        }
        directorTecnico.getJugadores().add(jugador);
        directorTecnicoRepository.save(directorTecnico);

    }
}
