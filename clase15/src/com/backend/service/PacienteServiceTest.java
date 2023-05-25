package com.backend.service;

import com.backend.dao.impl.PacienteDaoH2;
import com.backend.entity.Domicilio;
import com.backend.entity.Paciente;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PacienteServiceTest {
    private static Connection connection = null;
    private PacienteService pacienteService = new PacienteService(new PacienteDaoH2());

    /*
    @BeforeAll
    static void doBefore() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/clase15pruebas;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "sa");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }*/

    @Test
    public void deberiaAgregarUnPaciente(){
        Paciente pacTest = new Paciente("Nombre", "Apellido", 123456, LocalDate.of(2023, 05, 02), new Domicilio("Calle", 13, "Localidad", "Provincia"));

        Paciente pacienteResult = pacienteService.guardarPaciente(pacTest);

        assertNotNull(pacienteResult);
        assertEquals(123456, pacienteResult.getDni());

    }


    @Test
    public void deberiaEliminarElPacienteConId3(){
        pacienteService.eliminarPaciente(3);
        assertNull( pacienteService.buscarPacientePorId(3));
    }

    @Test
    public void listarTodosLosPacientes(){
        List<Paciente> pacientesTest = pacienteService.listarPacientes();
        assertFalse(pacientesTest.isEmpty());
        assertTrue(pacientesTest.size() >= 3);

    }

}