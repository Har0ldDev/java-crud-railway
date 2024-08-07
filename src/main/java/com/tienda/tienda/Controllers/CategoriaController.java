package com.tienda.tienda.Controllers;

import com.tienda.tienda.Entities.Categoria;
import com.tienda.tienda.Services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> getAllCategoria(){
        return categoriaService.getAllCategoria();
    }


    @GetMapping("/{id}")
    public Categoria getCategoriaById(@PathVariable Long id){
        return categoriaService.getCategoriaById(id);
    }

    @PostMapping
    public Categoria crearCategoria(@RequestBody Categoria categoria){
        return categoriaService.saveCategoria(categoria);
    }

    @PutMapping("/{id}")
    public Categoria setNombreCategoria(@PathVariable Long id, @RequestParam String nombre){
        return categoriaService.setNombreCategoria(id,nombre);
    }

    @DeleteMapping("/{id}")
    public String deleteCategoria(@PathVariable Long id){
        return categoriaService.deleteCategoria(id);
    }

}
