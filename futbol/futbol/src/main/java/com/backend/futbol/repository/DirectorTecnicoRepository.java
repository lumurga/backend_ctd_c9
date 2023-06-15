package com.backend.futbol.repository;

import com.backend.futbol.entity.DirectorTecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorTecnicoRepository extends JpaRepository<DirectorTecnico, Long> {
}
