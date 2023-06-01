package com.backend.clase23.service.impl;


import com.backend.clase23.dao.IDao;
import com.backend.clase23.entity.Paciente;
import com.backend.clase23.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PacienteService implements IPacienteService {
    private IDao<Paciente> pacienteIDao;

    @Autowired
    public PacienteService(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }

    public Paciente guardarPaciente(Paciente paciente) {
        return pacienteIDao.guardar(paciente);
    }

    public Paciente buscarPacientePorId(int id) {
        return pacienteIDao.buscarPorId(id);
    }

    @Override
    public List<Paciente> listarPacientes() {
        return pacienteIDao.listarTodos();
    }

    @Override
    public Paciente buscarPacientePorDni(String dni) {
        return pacienteIDao.buscarPorCriterio(dni);
    }

    public void eliminarPaciente(int id) {
        pacienteIDao.eliminar(id);
    }

}
