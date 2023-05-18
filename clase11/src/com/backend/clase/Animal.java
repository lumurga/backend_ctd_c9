package com.backend.clase;

import org.apache.log4j.Logger;

import java.sql.*;

public class Animal {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Animal.class);
        String create = "DROP TABLE IF EXISTS ANIMALES; CREATE TABLE ANIMALES (ID INT AUTO_INCREMENT PRIMARY KEY, NOMBRE VARCHAR(100) NOT NULL, TIPO VARCHAR(100) NOT NULL)";
        String insert = "INSERT INTO ANIMALES (NOMBRE, TIPO) values('Homero', 'perro'), ('Cleo', 'perro'), ('Juana', 'gato'), ('China', 'gato'), ('Greta', 'gato')";
        String delete = "DELETE FROM ANIMALES WHERE ID = 3";
        //String select = "SELECT * FROM ANIMALES";

        Connection connection = null;

        try {
            //me conecto
            connection = getConnection();

            //crear la tabla
            Statement st = connection.createStatement();
            st.execute(create);

            //agregar los 5 animales
            st.execute(insert);


            //hacer un select para ver los registros insertados
            ResultSet resultSet = st.executeQuery("SELECT * FROM ANIMALES");
            //recorrer el rs
            while (resultSet.next()){
                logger.info(resultSet.getInt(1) + " - " + resultSet.getString(2) + " - " + resultSet.getString(3));
            }
            //eliminar 1
            st.execute(delete);

            //volver a correr el select
            resultSet = st.executeQuery("SELECT * FROM ANIMALES");
            //recorrer el rs
            while (resultSet.next()){
                logger.info(resultSet.getInt(1) + " - " + resultSet.getString(2) + " - " + resultSet.getString(3));
            }


        } catch (Exception e){
            logger.error(e.getMessage());
        } finally {
            try{
                connection.close();
            } catch (Exception ex){
                logger.error(ex.getMessage());
            }
        }

    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        //indicar que driver voy a usar
        Class.forName("org.h2.Driver");
        //crear la conexion con la base de datos de H2, si no existe la va a crear
        //alt + 126
        return DriverManager.getConnection("jdbc:h2:~/c9clase11", "sa", "sa");
    }
}
