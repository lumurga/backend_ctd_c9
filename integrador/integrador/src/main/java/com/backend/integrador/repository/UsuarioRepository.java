package com.backend.integrador.repository;

import com.backend.integrador.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    @Query("Select u from Usuario u where u.username =:username")
    Optional<Usuario> buscarPorUsername(String username);

}
