package com.tienda.tienda.Services;

import com.tienda.tienda.Entities.Categoria;
import com.tienda.tienda.Entities.Producto;
import com.tienda.tienda.Repositories.CategoriaRepository;
import com.tienda.tienda.Repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;


    //GET
    public List<Producto> getAllProductos(){
        return productoRepository.findAll();
    }

    public Producto getProductoById(Long id){
        return productoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encontró el Producto con el Id"));
    }
    /*Aquí se indica que la funcion "saveProducto()"recibirá un parametro de tipo Producto para que
    luego este pueda ejecutar la funcion que contiene, en este caso "productoRepository.save()"
    psdta: parametro aquí es "prodcuto"*/

    //saveProducto

    /*NOTA: Agregué categoría debido a que no podía ingresar los productos sin tener que escribir sus elementos completos de
    categoría, tenía que mandar el Id y nombre completo. Con mi modificacion ahora solamente se necesita mandar el id.
    */
    public Producto saveProducto(Producto producto){
        //Cargamos categoria desde la DB

        Categoria categoria = categoriaRepository.findById(producto.getCategoria().getId())
                .orElseThrow(()->new RuntimeException("No se encontró la Categoría con el Id: " + producto.getCategoria().getId()));
        producto.setCategoria(categoria);
        return  productoRepository.save(producto);
    }

    //DELETE MAS ABAJO ESTAN LOS PUTS
    public String deleteProducto(Long id){
       Producto producto =productoRepository.findById(id)
               .orElseThrow(()-> new RuntimeException("No se pudo encontrar el Producto con el Id: "+ id + "Eliminar"));
       productoRepository.delete(producto);
       return "El producto con el ID: " + id + " fue eliminado exitosamente.";
    }

    //PUT
    //El mismo cambio de saveProducto() solo que en updateProductos().
    public Producto updateProducto(Long id, Producto productoDetails){
        Producto producto = productoRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No se pudo encontrar el Producto con el Id: " + id));
        producto.setNombre(productoDetails.getNombre());
        producto.setCantidad(productoDetails.getCantidad());
        producto.setPrecio(productoDetails.getPrecio());
        producto.setDescripcion(productoDetails.getDescripcion());


        //Cargamos categoria desde la BD
        Categoria categoria = categoriaRepository.findById(productoDetails.getCategoria().getId())
                .orElseThrow(()-> new RuntimeException("No se encontró la categoría con el Id: " + productoDetails.getCategoria().getId()));
        productoDetails.setCategoria(categoria);

        return productoRepository.save(producto);
    }

    //SUMAR(PUT)
    public Producto sumarCantidad(Long id, int cantidad){
        Producto producto = productoRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No se pudo encontrar el Producto con el Id: "+ id + " (Sumar)"));
        producto.setCantidad(producto.getCantidad()+cantidad);
        return productoRepository.save(producto);
    }

    // RESTAR (PUT)
    public Producto restarCantidad(Long id, int cantidad){
        Producto producto = productoRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No se pudo encontrar el Producto con el Id: "+ id + " (Restar)"));
        if (producto.getCantidad() < cantidad){
            throw new RuntimeException("Cantidad insuficiente en stock");
        }
        producto.setCantidad(producto.getCantidad() - cantidad);
        return productoRepository.save(producto);

    }


}
