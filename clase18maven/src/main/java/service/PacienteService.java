package service;


import dao.IDao;
import entity.Paciente;

import java.util.List;

public class PacienteService {
    private IDao<Paciente> pacienteIDao;

    public PacienteService(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }

    public Paciente guardarPaciente(Paciente paciente) {
        return pacienteIDao.guardar(paciente);
    }

    public Paciente buscarPacientePorId(int id) {
        return pacienteIDao.buscarPorId(id);
    }

    public List<Paciente> listarPacientes() {
        return pacienteIDao.listarTodos();
    }

    public void eliminarPaciente(int id) {
        pacienteIDao.eliminar(id);
    }

}
