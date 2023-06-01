package com.backend.clase23.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Connection {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/c9clase23;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "sa");
    }

}
