package service;

import dao.H2Connection;
import dao.impl.PacienteDaoH2;
import entity.Domicilio;
import entity.Paciente;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PacienteServiceTest {
    private static Connection connection = null;
    private PacienteService pacienteService = new PacienteService(new PacienteDaoH2());


    @BeforeAll
    static void doBefore() throws ClassNotFoundException, SQLException {
        try {
            connection = H2Connection.getConnection();
            Statement st = connection.createStatement();
            st.execute("insert into DOMICILIOS(CALLE, NUMERO, LOCALIDAD, PROVINCIA) values ('Av Siempre Viva', 742, 'Springfield', 'Massachusetts'), ('Calle Wallaby', 42, 'Sydney', 'Nueva Gales del Sur')");
            st.execute("insert into PACIENTES (NOMBRE, APELLIDO, DNI, FECHA, DOMICILIO_ID) values ('Emiliano', 'Cellilli', 35464856, '2023-05-24', 1), ('Pablo', 'Clemente', 3548546, '2023-05-24', 2)");
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

    @Test
    public void deberiaAgregarUnPaciente() {
        Paciente pacTest = new Paciente("Nombre", "Apellido", 123456, LocalDate.of(2023, 05, 02), new Domicilio("Calle", 13, "Localidad", "Provincia"));

        Paciente pacienteResult = pacienteService.guardarPaciente(pacTest);

        assertEquals(3, pacienteResult.getId());
        assertEquals(123456, pacienteResult.getDni());

    }

    @Test
    public void deberiaEncontrarElPacienteConId2() {
        Paciente paciente = pacienteService.buscarPacientePorId(2);
        assertNotNull(paciente);
        assertEquals("Clemente", paciente.getApellido());
    }

    @Test
    public void deberiaEliminarElPacienteConId3() {
        pacienteService.eliminarPaciente(3);
        assertNull(pacienteService.buscarPacientePorId(3));
    }

    @Test
    public void listarTodosLosPacientes() {
        List<Paciente> pacientesTest = pacienteService.listarPacientes();
        assertFalse(pacientesTest.isEmpty());
        assertTrue(pacientesTest.size() >= 2);

    }

}