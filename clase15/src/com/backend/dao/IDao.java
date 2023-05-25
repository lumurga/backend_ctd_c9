package com.backend.dao;

import java.util.List;

public interface IDao<T> {
    //alta, buscarlos, eliminarlos y listarlos
    T guardar(T t);

    List<T> listarTodos();

    void eliminar(int id);

    T buscarPorId(int id);

}
