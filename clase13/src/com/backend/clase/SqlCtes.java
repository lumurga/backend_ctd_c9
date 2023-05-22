package com.backend.clase;

public class SqlCtes {

    public static final String CREATE = "DROP TABLE IF EXISTS CUENTAS; CREATE TABLE CUENTAS(ID INT PRIMARY KEY AUTO_INCREMENT, NOMBRE VARCHAR(100) NOT NULL, NUMERO_CUENTA INT NOT NULL, SALDO NUMERIC(10, 2) NOT NULL)";

    public static final String INSERT = "INSERT INTO CUENTAS (NOMBRE, NUMERO_CUENTA, SALDO) VALUES(?, ?, ?)";

    public static final String UPDATE = "UPDATE CUENTAS SET SALDO = ? WHERE NUMERO_CUENTA = ?";
    public static final String SELECT = "SELECT * FROM CUENTAS WHERE ID = ?";

}
