package com.backend.integrador.service;

import com.backend.integrador.dto.PacienteDto;
import com.backend.integrador.entity.Paciente;

import java.util.List;

public interface IPacienteService {
    List<Paciente> listarPacientes();
    PacienteDto buscarPacientePorId(int id);
    PacienteDto guardarPaciente(Paciente paciente);
    PacienteDto actualizarPaciente(Paciente paciente);
    void eliminarPaciente(int id);

}
