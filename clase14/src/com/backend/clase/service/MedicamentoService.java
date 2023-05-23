package com.backend.clase.service;

import com.backend.clase.dao.IDao;
import com.backend.clase.entity.Medicamento;

public class MedicamentoService {
    //capa de logica de negocio que interactua con la capa dao, pero desconoce los detalles de la implementacion de la misma
    private IDao<Medicamento> medicamentoIDao;

    public MedicamentoService(IDao<Medicamento> medicamentoIDao) {
        this.medicamentoIDao = medicamentoIDao;
    }

    public Medicamento guardarMedicamento(Medicamento medicamento){
        return medicamentoIDao.guardar(medicamento);
    }

}
