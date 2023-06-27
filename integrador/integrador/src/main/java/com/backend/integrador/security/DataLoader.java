package com.backend.integrador.security;

import com.backend.integrador.entity.Rol;
import com.backend.integrador.entity.Usuario;
import com.backend.integrador.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {


    private final UsuarioRepository usuarioRepository;

    @Autowired
    public DataLoader(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String passwordAdmin = bCryptPasswordEncoder.encode("admin");
        String passwordUser = bCryptPasswordEncoder.encode("user");

        usuarioRepository.save(new Usuario("Administrador", "admin", "admin@clinica.com", passwordAdmin, Rol.ADMIN));
        usuarioRepository.save(new Usuario("Usuario", "user", "user@clinica.com", passwordUser, Rol.USER));

    }
}
