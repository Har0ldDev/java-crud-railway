package com.tienda.tienda.Services;

import com.tienda.tienda.Entities.Categoria;
import com.tienda.tienda.Entities.Producto;
import com.tienda.tienda.Repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    //GETALL
    public List<Categoria> getAllCategoria(){
        return categoriaRepository.findAll();
    }

    //GET POR ID
    public Categoria getCategoriaById(Long id){
        return categoriaRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No se encontró la Categoria con el Id: "+id));
    }


    //Nueva instancia de categoria
    public Categoria saveCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    //PUT
    public Categoria setNombreCategoria(Long id, String nombre){
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No se encontró la Categoría con el Id" + id));
        categoria.setNombre(nombre);
        return categoriaRepository.save(categoria);
    }

    //DELETE
    public String deleteCategoria(Long id){
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No se pudo encontrar la Categoria con el Id"));
        categoriaRepository.delete(categoria);
        return "La categoría se eliminó exitosamente";
    }
}
