package com.tienda.tienda.Repositories;

import com.tienda.tienda.Entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
}
