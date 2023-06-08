package com.backend.integrador.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDate;

public class JsonPrinter {

    public static String toString(Object t) {
        Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter()).create();
        return gson.toJson(t).trim().replace("\n", "").replace("\t", "");
    }
}
