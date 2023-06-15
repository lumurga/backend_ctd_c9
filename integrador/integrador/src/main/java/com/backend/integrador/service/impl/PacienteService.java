package com.backend.integrador.service.impl;

import com.backend.integrador.dto.PacienteDto;
import com.backend.integrador.entity.Paciente;
import com.backend.integrador.repository.IDao;
import com.backend.integrador.service.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PacienteService implements IPacienteService {
    private final IDao<Paciente> pacienteIDao;
    private final ObjectMapper objectMapper;

    @Autowired
    public PacienteService(IDao<Paciente> pacienteIDao, ObjectMapper objectMapper) {
        this.pacienteIDao = pacienteIDao;
        this.objectMapper = objectMapper;
    }


    @Override
    public List<Paciente> listarPacientes() {
        return pacienteIDao.listarTodos();
    }

    @Override
    public PacienteDto buscarPacientePorId(int id) {
        return objectMapper.convertValue(pacienteIDao.buscarPorId(id), PacienteDto.class);
    }

    @Override
    public PacienteDto guardarPaciente(Paciente paciente) {
        return objectMapper.convertValue(pacienteIDao.guardar(paciente), PacienteDto.class);
    }

    @Override
    public PacienteDto actualizarPaciente(Paciente paciente) {
        return objectMapper.convertValue(pacienteIDao.actualizar(paciente), PacienteDto.class);
    }

    @Override
    public void eliminarPaciente(int id) {
        pacienteIDao.eliminar(id);
    }
}
