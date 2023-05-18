package com.backend.mesas;

public class Check implements IReserva{

    private ApiAvion apiAvion;
    private ApiHotel apiHotel;

    public Check() {
        apiAvion = new ApiAvion();
        apiHotel = new ApiHotel();
    }

    @Override
    public void buscar(String fechaIda, String fechaVuelta, String origen, String destino) {
        apiAvion.buscarVuelos(fechaIda, fechaVuelta, origen, destino);
    }

    @Override
    public void buscar(String fechaEntrada, String fechaSalida, String ciudad) {
        apiHotel.buscarHoteles(fechaEntrada, fechaSalida, ciudad);
    }
}
