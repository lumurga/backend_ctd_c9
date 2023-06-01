package com.backend.clase22.service.impl;

import com.backend.clase22.dao.IDao;
import com.backend.clase22.entity.Entrenador;
import com.backend.clase22.service.IEntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrenadorService implements IEntrenadorService {

    private IDao<Entrenador> entrenadorIDao;

    @Autowired
    public EntrenadorService(IDao<Entrenador> entrenadorIDao) {
        this.entrenadorIDao = entrenadorIDao;
    }

    @Override
    public List<Entrenador> listarTodosLosEntrenadores() {
        return entrenadorIDao.listarTodos();
    }
}
