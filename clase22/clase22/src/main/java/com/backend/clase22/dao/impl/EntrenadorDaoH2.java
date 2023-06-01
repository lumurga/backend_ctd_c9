package com.backend.clase22.dao.impl;

import com.backend.clase22.dao.DbConnection;
import com.backend.clase22.dao.IDao;
import com.backend.clase22.entity.Entrenador;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class EntrenadorDaoH2 implements IDao<Entrenador> {

    private static final Logger LOGGER = LoggerFactory.getLogger(EntrenadorDaoH2.class);

    @Override
    public List<Entrenador> listarTodos() {
        Connection connection = null;
        List<Entrenador> entrenadores = new ArrayList<>();
        try{
            connection = DbConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM ENTRENADORES");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                //Entrenador entrenador = new Entrenador(rs.getInt(1), rs.getString(2));
                entrenadores.add(new Entrenador(rs.getInt(1), rs.getString(2)));
            }
            LOGGER.info("Entrenadores: " + entrenadores);

        }  catch (Exception e) {
            LOGGER.error("Ha ocurrido un error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("Ha ocurrido un error al intentar cerrar la conexion: {}", ex.getMessage());
                ex.printStackTrace();
            }
        }

        return entrenadores;
    }
}
