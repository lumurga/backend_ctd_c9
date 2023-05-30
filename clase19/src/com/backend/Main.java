package com.backend;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Perro> perros = new ArrayList<>();
        Perro perro1 = new Perro("Cleo", 11);
        Perro perro2 = new Perro("Homero", 9);
        Perro perro3 = new Perro("Albi", 2);

        perros.add(perro1);
        perros.add(perro2);
        perros.add(perro3);

        //guardar la lista de perros en un archivo - es un flujo de salida
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream("perritos.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(perros);
            oos.close();

        } catch (Exception e){
            e.printStackTrace();
        }

        //recuperar la coleccion del archivo - flujo de entrada
        FileInputStream fis = null;
        List<Perro> perritosInput = new ArrayList<>();

        try{
            fis = new FileInputStream("perritos.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            perritosInput = (List<Perro>) ois.readObject();
            ois.close();

        }catch (Exception e){
            e.printStackTrace();
        }


        //mostrar lo recuperado del archivo
        for (Perro perro : perritosInput){
            System.out.println("Perro: " + perro.getNombre() + " - edad: " + perro.getEdad());
        }



    }
}
