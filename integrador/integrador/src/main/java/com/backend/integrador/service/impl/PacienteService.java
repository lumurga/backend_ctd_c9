package com.backend.integrador.service.impl;

import com.backend.integrador.dto.DomicilioDto;
import com.backend.integrador.dto.PacienteDto;
import com.backend.integrador.entity.Domicilio;
import com.backend.integrador.entity.Paciente;
import com.backend.integrador.repository.PacienteRepository;
import com.backend.integrador.service.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PacienteService implements IPacienteService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PacienteService.class);
    private final PacienteRepository pacienteRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository, ObjectMapper objectMapper) {
        this.pacienteRepository = pacienteRepository;
        this.objectMapper = objectMapper;
    }


    @Override
    public List<PacienteDto> listarPacientes() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        List<PacienteDto> pacienteDtos = pacientes.stream()
                .map(paciente -> {
                    Domicilio dom = paciente.getDomicilio();
                    DomicilioDto domicilioDto = objectMapper.convertValue(dom, DomicilioDto.class);
                    return new PacienteDto(paciente.getId(), paciente.getNombre(), paciente.getApellido(), paciente.getDni(), paciente.getFechaIngreso(), domicilioDto);
                })
                .toList();

        LOGGER.info("Lista de todos los pacientes: {}", pacienteDtos);
        return pacienteDtos;
    }

    @Override
    public PacienteDto buscarPacientePorId(Long id) {
        Paciente pacienteBuscado = pacienteRepository.findById(id).orElse(null);
        PacienteDto pacienteDto = null;
        if (pacienteBuscado != null) {
            DomicilioDto domicilioDto = objectMapper.convertValue(pacienteBuscado.getDomicilio(), DomicilioDto.class);
            pacienteDto = objectMapper.convertValue(pacienteBuscado, PacienteDto.class);
            pacienteDto.setDomicilioDto(domicilioDto);
            LOGGER.info("Paciente encontrado: {}", pacienteDto);

        } else LOGGER.info("El id no se encuentra registrado en la base de datos");

        return pacienteDto;
    }

    @Override
    public PacienteDto guardarPaciente(Paciente paciente) {
        Paciente pacienteNuevo = pacienteRepository.save(paciente);
        DomicilioDto domicilioDto = objectMapper.convertValue(pacienteNuevo.getDomicilio(), DomicilioDto.class);
        PacienteDto pacienteDtoNuevo = objectMapper.convertValue(pacienteNuevo, PacienteDto.class);
        pacienteDtoNuevo.setDomicilioDto(domicilioDto);

        LOGGER.info("Nuevo paciente registrado con exito: {}", pacienteDtoNuevo);

        return pacienteDtoNuevo;
    }

    @Override
    public PacienteDto actualizarPaciente(Paciente paciente) {
        Paciente pacienteAActualizar = pacienteRepository.findById(paciente.getId()).orElse(null);
        PacienteDto pacienteActualizadoDto = null;

        if (pacienteAActualizar != null) {
            pacienteAActualizar = paciente;
            pacienteRepository.save(pacienteAActualizar);

            DomicilioDto domicilioDto = objectMapper.convertValue(pacienteAActualizar.getDomicilio(), DomicilioDto.class);
            pacienteActualizadoDto = objectMapper.convertValue(pacienteAActualizar, PacienteDto.class);
            pacienteActualizadoDto.setDomicilioDto(domicilioDto);
            LOGGER.info("Paciente actualizado con exito: {}", pacienteActualizadoDto);

        } else LOGGER.error("No fue posible actualizar los datos ya que el paciente no se encuentra registrado");

        return pacienteActualizadoDto;

    }

    @Override
    public void eliminarPaciente(Long id) {
        pacienteRepository.deleteById(id);
        LOGGER.warn("Se ha eliminado el paciente con id {}", id);
    }
}
