package com.backend.mesas;

public class ServicioDescarga implements Descarga{
    @Override
    public String descargarCancion(Usuario usuario) {
        return "Iniciando descarga para el usuario " + usuario.getId();
    }
}
