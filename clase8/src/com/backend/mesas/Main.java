package com.backend.mesas;

public class Main {
    public static void main(String[] args) {

        Check cliente1 = new Check();
        cliente1.buscar("1/08/2023", "20/08/2023", "Colombia", "Argentina");

        cliente1.buscar("1/08/2023", "20/08/2023", "Buenos Aires");

    }
}
