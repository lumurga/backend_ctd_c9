package com.backend.clase22.controller;

import com.backend.clase22.entity.Entrenador;
import com.backend.clase22.service.IEntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/entrenadores")
public class EntrenadorController {
    private IEntrenadorService entrenadorService;

    @Autowired
    public EntrenadorController(IEntrenadorService entrenadorService) {
        this.entrenadorService = entrenadorService;
    }

    @GetMapping("/lista")
    public List<Entrenador> listarEntrenadores(){
        return entrenadorService.listarTodosLosEntrenadores();
    }

}
