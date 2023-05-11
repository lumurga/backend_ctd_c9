package com.backend.mesas;

public class MenuVegetariano extends Menu{
    private int cantSalsas;

    public MenuVegetariano(double precioBase, int cantSalsas) {
        super(precioBase);
        this.cantSalsas = cantSalsas;
    }

    public int getCantSalsas() {
        return cantSalsas;
    }

    public void setCantSalsas(int cantSalsas) {
        this.cantSalsas = cantSalsas;
    }
}
