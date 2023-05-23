package com.backend.clase.dao.impl;

import com.backend.clase.dao.H2Connection;
import com.backend.clase.dao.IDao;
import com.backend.clase.entity.Medicamento;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;

public class MedicamentoDaoH2 implements IDao<Medicamento> {
    private static final Logger LOGGER = Logger.getLogger(MedicamentoDaoH2.class);


    @Override
    public Medicamento guardar(Medicamento medicamento) {
        Connection connection = null;
        try{
         connection = H2Connection.getConnetion();
         connection.setAutoCommit(false);

         PreparedStatement ps = connection.prepareStatement("INSERT INTO MEDICAMENTOS (CODIGO, NOMBRE, LABORATORIO, CANTIDAD, PRECIO) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
         ps.setString(1, medicamento.getCodigo());
         ps.setString(2, medicamento.getNombre());
         ps.setString(3, medicamento.getLaboratorio());
         ps.setInt(4, medicamento.getCantidad());
         ps.setDouble(5, medicamento.getPrecio());
         ps.execute();

         //vamos a obtener el id para completar los datos que tenemos del medicamento
         ResultSet key = ps.getGeneratedKeys();
         while(key.next()){
                //busco el id generado y se lo seteo al objeto medicamento
             int id = key.getInt(1);
             medicamento.setId(id);
         }
         LOGGER.info("Medicamento guardado: " + medicamento);



         connection.commit();
        } catch (Exception e){
        LOGGER.error(e.getMessage());
        e.printStackTrace();
            if(connection != null){
                try {
                    connection.rollback();
                    System.out.println("Tuvimos un problema");
                    e.printStackTrace();
                } catch (SQLException exception){
                    LOGGER.error(exception.getMessage());
                    exception.printStackTrace();
                }
            }
    } finally {
        try{
            connection.close();
        } catch (Exception ex){
            LOGGER.error("No se pudo cerrar la conexion: " + ex.getMessage());
        }
    }


        return medicamento;
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
