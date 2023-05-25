package com.backend.clase.dao.impl;

import com.backend.clase.dao.H2Connection;
import com.backend.clase.dao.IDao;
import com.backend.clase.entity.Medicamento;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicamentoDaoH2 implements IDao<Medicamento> {
    private static final Logger LOGGER = Logger.getLogger(MedicamentoDaoH2.class);


    @Override
    public Medicamento guardar(Medicamento medicamento) {
        Connection connection = null;
        try {
            connection = H2Connection.getConnection();
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
            while (key.next()) {
                //busco el id generado y se lo seteo al objeto medicamento
                int id = key.getInt(1);
                medicamento.setId(id);
            }
            LOGGER.info("Medicamento guardado: " + medicamento);

            connection.commit();

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                    System.out.println("Tuvimos un problema");
                    e.printStackTrace();
                } catch (SQLException exception) {
                    LOGGER.error(exception.getMessage());
                    exception.printStackTrace();
                }
            }
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("No se pudo cerrar la conexion: " + ex.getMessage());
            }
        }

        return medicamento;
    }


    @Override
    public List<Medicamento> listarTodos() {
        Connection connection = null;
        List<Medicamento> medicamentos = new ArrayList<>();
        try {
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM MEDICAMENTOS");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                medicamentos.add(crearObjetoMedicamento(rs));
            }
            connection.commit();
            LOGGER.info("Listado de todos los medicamentos: " + medicamentos);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                    System.out.println("Tuvimos un problema");
                    e.printStackTrace();
                } catch (SQLException exception) {
                    LOGGER.error(exception.getMessage());
                    exception.printStackTrace();
                }
            }
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("Ha ocurrido un error al intentar cerrar la bdd. " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return medicamentos;
    }

    @Override
    public Medicamento buscarPorId(int id) {
        Medicamento medicamento = null;
        Connection connection = null;
        try {
            connection = H2Connection.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM MEDICAMENTOS WHERE ID = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            //no es necesario el while
            while (rs.next()) {
                medicamento = crearObjetoMedicamento(rs);
            }

            LOGGER.info("Se ha encontrado el medicamento " + medicamento);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                    System.out.println("Tuvimos un problema");
                    e.printStackTrace();
                } catch (SQLException exception) {
                    LOGGER.error(exception.getMessage());
                    exception.printStackTrace();
                }
            }
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("Ha ocurrido un error al intentar cerrar la bdd. " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return medicamento;
    }


    private Medicamento crearObjetoMedicamento(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String nombre = rs.getString("nombre");
        String codigo = rs.getString("codigo");
        String labortorio = rs.getString("laboratorio");
        int cantidad = rs.getInt("cantidad");
        double precio = rs.getDouble("precio");

        return new Medicamento(id, codigo, nombre, labortorio, cantidad, precio);

    }


}
