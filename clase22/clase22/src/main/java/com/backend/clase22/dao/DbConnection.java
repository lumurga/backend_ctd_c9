package com.backend.clase22.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/c9clase22;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "sa");
    }
}
