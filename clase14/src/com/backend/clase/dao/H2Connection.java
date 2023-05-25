package com.backend.clase.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class H2Connection {
    private static final String CREATE = "DROP TABLE IF EXISTS MEDICAMENTOS; CREATE TABLE MEDICAMENTOS(ID INT AUTO_INCREMENT PRIMARY KEY, CODIGO VARCHAR(50) NOT NULL, NOMBRE VARCHAR(100) NOT NULL, LABORATORIO VARCHAR(100) NOT NULL, CANTIDAD INT NOT NULL, PRECIO NUMERIC(10, 2) NOT NULL)";

    public static void crearTabla() {
        Connection connection = null;
        try {
            connection = getConnection();
            Statement st = connection.createStatement();
            st.execute(CREATE);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }


    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/c9clase14", "sa", "sa");
    }


}
