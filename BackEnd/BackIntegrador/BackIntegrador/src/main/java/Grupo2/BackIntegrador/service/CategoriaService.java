package Grupo2.BackIntegrador.service;

import Grupo2.BackIntegrador.DTO.CategoriaDTO;
import Grupo2.BackIntegrador.Exception.ResourceNotFoundException;
import Grupo2.BackIntegrador.model.Categoria;
import Grupo2.BackIntegrador.repository.CategoriaRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private CategoriaRepository categoriaRepository;
    private static final Logger LOGGER=Logger.getLogger(CategoriaService.class);
    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {

        this.categoriaRepository = categoriaRepository;
    }

    public List<CategoriaDTO> listarCategorias() {
        LOGGER.info("Se inició el listado de todas las Categorias");
        List<Categoria>categoriasEncontradas=categoriaRepository.findAll();
        List<CategoriaDTO> respuesta= new ArrayList<>();
        for (Categoria c:categoriasEncontradas){
            respuesta.add(categoriaACategoriaDTO(c));
        }
        return respuesta;
    }

    public CategoriaDTO guardarCategoria(CategoriaDTO categoria){
        LOGGER.info("Se inició una operación de guardado de la categoria con titulo: "+ categoria.getTitulo());
        Categoria categoriaAGuardar=categoriaDTOaCategoria(categoria);
        Categoria categoriaGuardada=categoriaRepository.save(categoriaAGuardar);
        return categoriaACategoriaDTO(categoriaGuardada);
    }

    public void actualizarCategoria(CategoriaDTO categoria){
        LOGGER.info("Se inició una operación de actualización de la categoria con id="+
                categoria.getId());
        Categoria categoriaAActualizar=categoriaDTOaCategoria(categoria);
        categoriaRepository.save(categoriaAActualizar);
    }

    public void eliminarCategoria(Long id) throws ResourceNotFoundException {
        Optional<CategoriaDTO> categoriaAEliminar=buscarCategoriaXId(id);
        if (categoriaAEliminar.isPresent()){
            categoriaRepository.deleteById(id);
            LOGGER.warn("Se realizo una operación de eliminación de la categoria con" +
                    "id="+id);
        }
        else{
            throw new ResourceNotFoundException("La categoria a eliminar no existe" +
                    " en la base de datos, se intentó encontrar sin éxito en id= "+id);
        }

    }

    public Optional<CategoriaDTO> buscarCategoriaXId(Long id){
        LOGGER.info("Se inició una operación de búsqueda de la categoria con id="+id);
        Optional<Categoria> categoriaBuscada=categoriaRepository.findById(id);
        if (categoriaBuscada.isPresent()){
            return Optional.of(categoriaACategoriaDTO(categoriaBuscada.get()));
        }
        else {
            return Optional.empty();
        }
    }

    private CategoriaDTO categoriaACategoriaDTO(Categoria categoria){
        CategoriaDTO respuesta = new CategoriaDTO();
        respuesta.setId(categoria.getId());
        respuesta.setTitulo(categoria.getTitulo());
        respuesta.setDescripcion(categoria.getDescripcion());
        respuesta.setUrl_imagen(categoria.getUrl_imagen());
        return respuesta;
    }

    private Categoria categoriaDTOaCategoria(CategoriaDTO categoriaDTO){
        Categoria categoria= new Categoria();
        categoria.setId(categoriaDTO.getId());
        categoria.setTitulo(categoriaDTO.getTitulo());
        categoria.setDescripcion(categoriaDTO.getDescripcion());
        categoria.setUrl_imagen(categoriaDTO.getUrl_imagen());
        return categoria;
    }
}
