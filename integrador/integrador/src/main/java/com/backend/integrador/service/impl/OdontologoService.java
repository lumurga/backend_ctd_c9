package com.backend.integrador.service.impl;


import com.backend.integrador.dto.OdontologoDto;
import com.backend.integrador.dto.TurnoDto;
import com.backend.integrador.entity.Odontologo;
import com.backend.integrador.repository.IDao;
import com.backend.integrador.service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class OdontologoService implements IOdontologoService {
    private final ObjectMapper objectMapper;
    private final IDao<Odontologo> odontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologoIDao, ObjectMapper objectMapper) {
        this.odontologoIDao = odontologoIDao;
        this.objectMapper = objectMapper;
    }

    public OdontologoDto buscarOdontologoPorId(int id) {
        return objectMapper.convertValue(odontologoIDao.buscarPorId(id), OdontologoDto.class);
    }

    public List<OdontologoDto> listarOdontologos() {
        return odontologoIDao.listarTodos().stream().map(o -> objectMapper.convertValue(o, OdontologoDto.class)).collect(Collectors.toList());
    }

    @Override
    public OdontologoDto registrarOdontologo(Odontologo odontologo) {
        return objectMapper.convertValue(odontologoIDao.guardar(odontologo), OdontologoDto.class);
    }

    @Override
    public OdontologoDto actualizarOdontologo(Odontologo odontologo) {
        return objectMapper.convertValue(odontologoIDao.actualizar(odontologo), OdontologoDto.class);
    }

    public void eliminarOdontologo(int id) {
        odontologoIDao.eliminar(id);
    }


}
