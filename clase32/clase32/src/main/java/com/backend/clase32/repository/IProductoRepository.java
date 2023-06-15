package com.backend.clase32.repository;

import com.backend.clase32.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IProductoRepository extends JpaRepository<Producto, Long> {

}
