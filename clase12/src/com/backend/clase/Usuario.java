package com.backend.clase;

import org.apache.log4j.Logger;

import java.sql.*;


public class Usuario {

    private final static Logger LOGGER = Logger.getLogger(Usuario.class);

    public static void main(String[] args) {
        LOGGER.info("Iniciando el metodo main...");

        Connection connection = null;
        try{
            connection = getConnection();
            Statement st = connection.createStatement();
            st.execute(SqlAux.CREATE);
            st.execute(SqlAux.INSERT);
            //st.execute(SqlAux.DELETE);

            ResultSet rs = st.executeQuery(SqlAux.SELECT);
            while (rs.next()){
                LOGGER.info("-- Usuario --" + " Id: " + rs.getInt(1) + " - Nombre: " + rs.getString(2) + " - Apellido: " + rs.getString(3) + " - Edad: " + rs.getInt(4));
            }

            PreparedStatement ps = connection.prepareStatement(SqlAux.DELETE);
            int id = 3;
            ps.setInt(1, id);
            ps.execute();

            LOGGER.warn("Se ha borrado el usuario con id " + id);

            rs = st.executeQuery(SqlAux.SELECT);
            while (rs.next()){
                LOGGER.info("-- Usuario --" + " Id: " + rs.getInt(1) + " - Nombre: " + rs.getString(2) + " - Apellido: " + rs.getString(3) + " - Edad: " + rs.getInt(4));
            }


        } catch (Exception e){
            LOGGER.error(e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (Exception ex){
                LOGGER.error(ex.getMessage());
            }
        }

    }


    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/c9clase12", "sa", "sa");
    }

}
