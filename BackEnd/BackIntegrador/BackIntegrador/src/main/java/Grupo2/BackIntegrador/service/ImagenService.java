package Grupo2.BackIntegrador.service;

import Grupo2.BackIntegrador.DTO.ImagenDTO;
import Grupo2.BackIntegrador.Exception.ResourceNotFoundException;
import Grupo2.BackIntegrador.model.Categoria;
import Grupo2.BackIntegrador.model.Imagen;
import Grupo2.BackIntegrador.repository.CategoriaRepository;
import Grupo2.BackIntegrador.repository.ImagenRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ImagenService {

    private ImagenRepository imagenRepository;
    private static final Logger LOGGER=Logger.getLogger(ImagenService.class);
    @Autowired
    public ImagenService(ImagenRepository imagenRepository) {

        this.imagenRepository = imagenRepository;
    }

    public List<ImagenDTO> listarimagenes() {
        LOGGER.info("Se inició el listado de todas las imagenes");
        List<Imagen> imagenesEncontradas=imagenRepository.findAll();
        List<ImagenDTO> respuesta= new ArrayList<>();
        for (Imagen i:imagenesEncontradas){
            respuesta.add(imagenAImagenDTO(i));
        }
        return respuesta;
    }

    public ImagenDTO guardarImagen(ImagenDTO imagen){
        LOGGER.info("Se inició una operación de guardado de la imagen con titulo: "+
                imagen.getTitulo());
        Imagen imagenAGuardar=imagenDTOaImagen(imagen);
        Imagen imagenGuardada=imagenRepository.save(imagenAGuardar);
        return imagenAImagenDTO(imagenGuardada);
    }

    public void actualizarImagen(ImagenDTO imagen){
        LOGGER.info("Se inició una operación de actualización de la imagen con id="+
                imagen.getId());
        Imagen imagenAActualizar=imagenDTOaImagen(imagen);
        imagenRepository.save(imagenAActualizar);
    }

    public void eliminarImagen(Long id) throws ResourceNotFoundException {
        Optional<ImagenDTO> imagenAEliminar=buscarImagenXId(id);
        if (imagenAEliminar.isPresent()){
            imagenRepository.deleteById(id);
            LOGGER.warn("Se realizo una operación de eliminación de la imagen con" +
                    "id="+id);
        }
        else{
            throw new ResourceNotFoundException("La imagen a eliminar no existe" +
                    " en la base de datos, se intentó encontrar sin éxito en id= "+id);
        }

    }

    public Optional<ImagenDTO> buscarImagenXId(Long id){
        LOGGER.info("Se inició una operación de búsqueda de la imagen con id="+id);
        Optional<Imagen> imagenBuscada=imagenRepository.findById(id);
        if (imagenBuscada.isPresent()){
            return Optional.of(imagenAImagenDTO(imagenBuscada.get()));
        }
        else {
            return Optional.empty();
        }
    }

    private ImagenDTO imagenAImagenDTO(Imagen imagen){
        ImagenDTO respuesta= new ImagenDTO();
        respuesta.setId(imagen.getId());
        respuesta.setTitulo(imagen.getTitulo());
        respuesta.setUrl_img(imagen.getUrl_img());
        return respuesta;
    }

    private Imagen imagenDTOaImagen(ImagenDTO imagenDTO){
        Imagen imagen = new Imagen();
        imagen.setId(imagenDTO.getId());
        imagen.setTitulo(imagenDTO.getTitulo());
        imagen.setUrl_img(imagenDTO.getUrl_img());
        return imagen;
    }
}