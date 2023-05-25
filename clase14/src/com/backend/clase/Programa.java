package com.backend.clase;

import com.backend.clase.dao.H2Connection;
import com.backend.clase.dao.impl.MedicamentoDaoEnMemoria;
import com.backend.clase.dao.impl.MedicamentoDaoH2;
import com.backend.clase.entity.Medicamento;
import com.backend.clase.service.MedicamentoService;

import java.util.ArrayList;

public class Programa {
    public static void main(String[] args) {
        H2Connection.crearTabla();

        Medicamento med1 = new Medicamento("M35465", "Aspirina", "Bayer", 50, 200);
        Medicamento med2 = new Medicamento("M35465", "Aspirina", "Bayer", 50, 200);

        //seteamos la implementacion de la IDao que queremos que se use, sea H2, en memoria, MySql, o la que tengamos implementada

        MedicamentoService medicamentoService = new MedicamentoService(new MedicamentoDaoH2());

        medicamentoService.guardarMedicamento(med1);
        medicamentoService.guardarMedicamento(med2);
        System.out.println("-----------------------------------------------");
        medicamentoService.listarTodosLosMedicamentos();
        System.out.println("-----------------------------------------------");
        medicamentoService.buscarMedicamentoPorId(2);


        System.out.println("////////////////////////////////////////////////");
        MedicamentoService medicamentoService1 = new MedicamentoService(new MedicamentoDaoEnMemoria(new ArrayList<>()));
        med1.setId(1);
        med2.setId(2);
        medicamentoService1.guardarMedicamento(med1);
        medicamentoService1.guardarMedicamento(med2);
        System.out.println("-----------------------------------------------");
        medicamentoService1.listarTodosLosMedicamentos();
        System.out.println("-----------------------------------------------");
        medicamentoService1.buscarMedicamentoPorId(1);

    }
}
