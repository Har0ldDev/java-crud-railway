package com.tienda.tienda.Controllers;

import com.tienda.tienda.Entities.Producto;
import com.tienda.tienda.Services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> getAllProductos(){
        return productoService.getAllProductos();
    }

    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable Long id){
        return productoService.getProductoById(id);
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto){
        return productoService.saveProducto(producto);
    }

    //Aquí comienzan los PUTS

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Long id,@RequestBody Producto producto){
        return productoService.updateProducto(id, producto);
    }

    //SUMA Y RESTA
    @PutMapping("/{id}/sumar")
    public Producto sumarCantidad(@PathVariable Long id, @RequestParam int cantidad){
        return productoService.sumarCantidad(id, cantidad);
    }
    @PutMapping("/{id}/restar")
    public Producto restarCantidad(@PathVariable Long id, @RequestParam int cantidad){
        return productoService.restarCantidad(id, cantidad);
    }

    //Aquí terminan los PUTS

    @DeleteMapping("/{id}")
    public String deleteProducto(@PathVariable Long id){
        return productoService.deleteProducto(id);
    }

}
