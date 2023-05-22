package com.backend.clase;

import org.apache.log4j.Logger;

import java.sql.*;

public class Transaccion {

    private static final Logger LOGGER = Logger.getLogger(Transaccion.class);
    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta("Lu", 354645656, 50000);
        Connection connection = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);

            Statement st = connection.createStatement();
            st.execute(SqlCtes.CREATE);

            //Insertar un registro en la tabla usando el objeto cuenta ya creado
            PreparedStatement ps = connection.prepareStatement(SqlCtes.INSERT);
            ps.setString(1, cuenta.getNombre());
            ps.setInt(2, cuenta.getNumeroCuenta());
            ps.setDouble(3, cuenta.getSaldo());
            ps.execute();

            //agregarle 10 a la cuenta
            PreparedStatement psUp = connection.prepareStatement(SqlCtes.UPDATE);

            psUp.setDouble(1, cuenta.getSaldo() + 10);
            psUp.setInt(2, cuenta.getNumeroCuenta());
            psUp.execute();
            //cuenta.setSaldo(cuenta.getSaldo()+10);

            psUp.setDouble(1, cuenta.getSaldo() + 15);
            psUp.setInt(2, cuenta.getNumeroCuenta());
            psUp.execute();

            //int aux = 1 / 0;

            //mostrar info
            PreparedStatement psSel = connection.prepareStatement(SqlCtes.SELECT);
            psSel.setInt(1, 1);
            ResultSet rs = psSel.executeQuery();
            while (rs.next()){
                LOGGER.info(rs.getString(2) + " - Saldo $" + rs.getDouble(4));
            }

            connection.commit();
            //connection.setAutoCommit(true);



        } catch (Exception e){
            LOGGER.error(e.getMessage());
            if(connection != null){
                try {
                    connection.rollback();
                    LOGGER.info("Tuvimos un problema");
                    e.printStackTrace();
                } catch (SQLException ex){
                    LOGGER.error(ex.getMessage());
                }
            }
        } finally {
            try{
                connection.close();
            } catch (Exception e){
                LOGGER.error(e.getMessage());
            }
        }



    }

    private static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/c9clase13", "sa", "sa");
    }
}
