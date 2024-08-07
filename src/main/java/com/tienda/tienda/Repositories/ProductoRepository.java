package com.tienda.tienda.Repositories;

import com.tienda.tienda.Entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
