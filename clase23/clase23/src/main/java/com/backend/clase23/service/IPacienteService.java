package com.backend.clase23.service;

import com.backend.clase23.entity.Paciente;

import java.util.List;

public interface IPacienteService {
    List<Paciente> listarPacientes();
    Paciente buscarPacientePorDni(String dni);

}
