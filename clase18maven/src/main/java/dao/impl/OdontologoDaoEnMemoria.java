package dao.impl;

import dao.IDao;
import entity.Odontologo;
import org.apache.log4j.Logger;

import java.util.List;

public class OdontologoDaoEnMemoria implements IDao<Odontologo> {

    private static final Logger LOGGER = Logger.getLogger(OdontologoDaoEnMemoria.class);

    private List<Odontologo> odontologoRepository;

    public OdontologoDaoEnMemoria(List<Odontologo> odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }


    @Override
    public Odontologo guardar(Odontologo odontologo) {
        odontologoRepository.add(odontologo);
        LOGGER.info("Odontologo registrado: " + odontologo);
        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {
        LOGGER.info("Listado de todos los odontologos: " + odontologoRepository);
        return odontologoRepository;
    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public Odontologo buscarPorId(int id) {
        return null;
    }
}
