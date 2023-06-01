package com.backend.clase22.dao;

import java.util.List;

public interface IDao<T> {
    List<T> listarTodos();
}
