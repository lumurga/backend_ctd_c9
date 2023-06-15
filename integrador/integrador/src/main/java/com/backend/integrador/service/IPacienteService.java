package com.backend.integrador.service;

import com.backend.integrador.dto.PacienteDto;
import com.backend.integrador.entity.Paciente;

import java.util.List;

public interface IPacienteService {
    List<PacienteDto> listarPacientes();

    PacienteDto buscarPacientePorId(Long id);

    PacienteDto guardarPaciente(Paciente paciente);

    PacienteDto actualizarPaciente(Paciente paciente);

    void eliminarPaciente(Long id);

}
