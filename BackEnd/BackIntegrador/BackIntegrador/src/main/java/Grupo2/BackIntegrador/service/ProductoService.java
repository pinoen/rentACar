package Grupo2.BackIntegrador.service;

import Grupo2.BackIntegrador.DTO.ProductoDTO;
import Grupo2.BackIntegrador.Exception.ResourceNotFoundException;


import Grupo2.BackIntegrador.model.*;
import Grupo2.BackIntegrador.repository.ProductoRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private ProductoRepository productoRepository;
    private static final Logger LOGGER=Logger.getLogger(ProductoService.class);
    @Autowired
    public ProductoService(ProductoRepository productoRepository) {

        this.productoRepository = productoRepository;
    }

    public List<ProductoDTO> listarProducto() {
        LOGGER.info("Se inició el listado de todas las productos");
        List<Producto>productosEncontrados=productoRepository.findAll();
        List<ProductoDTO> respuesta= new ArrayList<>();
        for (Producto p:productosEncontrados){
            respuesta.add(productoAProductoDTO(p));
        }
        return respuesta;
    }

    public ProductoDTO guardarProducto(ProductoDTO producto){
        LOGGER.info("Se inició una operación de guardado de la producto con titulo: "+
                producto.getTitulo());
        Producto productoAGuardar=productoDTOaProducto(producto);
        Producto productoGuardado=productoRepository.save(productoAGuardar);
        return productoAProductoDTO(productoGuardado);
    }

    public void actualizarProducto(ProductoDTO producto){
        LOGGER.info("Se inició una operación de actualización de la producto con id="+
                producto.getId());
        Producto productoAActualizar=productoDTOaProducto(producto);
        productoRepository.save(productoAActualizar);
    }

    public void eliminarProducto(Long id) throws ResourceNotFoundException {
        Optional<ProductoDTO> productoAEliminar=buscarProductoXId(id);
        if (productoAEliminar.isPresent()){
            productoRepository.deleteById(id);
            LOGGER.warn("Se realizo una operación de eliminación de la producto con" +
                    "id="+id);
        }
        else{
            throw new ResourceNotFoundException("La producto a eliminar no existe" +
                    " en la base de datos, se intentó encontrar sin éxito en id= "+id);
        }

    }

    public Optional<ProductoDTO> buscarProductoXId(Long id){
        LOGGER.info("Se inició una operación de búsqueda de la producto con id="+id);
        Optional<Producto> productoBuscado=productoRepository.findById(id);
        if (productoBuscado.isPresent()){
            return Optional.of(productoAProductoDTO(productoBuscado.get()));
        }
        else {
            return Optional.empty();
        }
    }

    public List<Producto> buscarProductoPorCategoria(Categoria categoria) {
        LOGGER.info("Se inició euna busqueda de todos los productos con categoria id=" + categoria.getId());
        return productoRepository.findByCategoria(categoria);
    }

    private ProductoDTO productoAProductoDTO(Producto producto){
        ProductoDTO respuesta= new ProductoDTO();
        respuesta.setId(producto.getId());
        respuesta.setTitulo(producto.getTitulo());
        respuesta.setDescripcion(producto.getDescripcion());
        respuesta.setCategoria(producto.getCategoria());
        respuesta.setCiudad(producto.getCiudad());
        respuesta.setImagen(producto.getImagen());
        respuesta.setPolitica(producto.getPolitica());
        respuesta.setCaracteristica(producto.getCaracteristica());
        return respuesta;

    }

    private Producto productoDTOaProducto(ProductoDTO productoDTO){
        Producto producto= new Producto();
        Categoria categoria = new Categoria();
        Ciudad ciudad = new Ciudad();
        Imagen imagen = new Imagen();
        Politica politica = new Politica();
        Caracteristica caracteristica = new Caracteristica();
        categoria.setId(productoDTO.getCategoria().getId());
        ciudad.setId(productoDTO.getCiudad().getId());
        imagen.setId(productoDTO.getImagen());
        politica.setId(productoDTO.getPolitica());
        caracteristica.setId(productoDTO.getCaracteristica());
        return producto;
    }
}
