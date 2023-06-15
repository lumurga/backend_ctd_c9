package com.backend.futbol.repository;

import com.backend.futbol.entity.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long> {

    @Query("SELECT j FROM Jugador j WHERE j.tecnico.nombre = ?1")
    Set<Jugador> listarJugadoresPorTecnico(String nombreDt);

}
