package com.backend.clase;

public class SqlAux {
    public static final String CREATE = "DROP TABLE IF EXISTS USUARIOS; CREATE TABLE USUARIOS (ID INT AUTO_INCREMENT PRIMARY KEY, NOMBRE VARCHAR(100) NOT NULL, APELLIDO VARCHAR(100) NOT NULL, EDAD INT NOT NULL)";

    public static final String INSERT = "INSERT INTO USUARIOS (NOMBRE, APELLIDO, EDAD) VALUES ('Agustina', 'Barca', 19), ('Tania', 'Rodriguez', 42), ('Rodrigo', 'Ruiz', 40)";

    public static final String DELETE = "DELETE FROM USUARIOS WHERE ID = ?";

    public static final String SELECT = "SELECT * FROM USUARIOS";

}
