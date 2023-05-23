package com.backend.clase.dao.impl;

import com.backend.clase.dao.IDao;
import com.backend.clase.entity.Medicamento;

import java.util.List;

public class MedicamentoDaoEnMemoria implements IDao<Medicamento> {
    @Override
    public Medicamento guardar(Medicamento medicamento) {
        return null;
    }

    @Override
    public List<Medicamento> listarTodos() {
        return null;
    }

    @Override
    public Medicamento buscarPorId(int id) {
        return null;
    }
}
