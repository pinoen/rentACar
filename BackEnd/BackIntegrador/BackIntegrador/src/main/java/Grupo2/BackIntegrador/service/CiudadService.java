package Grupo2.BackIntegrador.service;

import Grupo2.BackIntegrador.DTO.CiudadDTO;
import Grupo2.BackIntegrador.Exception.ResourceNotFoundException;
import Grupo2.BackIntegrador.model.Ciudad;
import Grupo2.BackIntegrador.repository.CiudadRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CiudadService {

    private CiudadRepository ciudadRepository;
    private static final Logger LOGGER=Logger.getLogger(CiudadService.class);
    @Autowired
    public CiudadService(CiudadRepository ciudadRepository) {

        this.ciudadRepository = ciudadRepository;
    }

    public List<CiudadDTO> listarCiudad() {
        LOGGER.info("Se inició el listado de todas las ciudad");
        List<Ciudad>ciudadesEncontradas=ciudadRepository.findAll();
        List<CiudadDTO> respuesta= new ArrayList<>();
        for (Ciudad c:ciudadesEncontradas){
            respuesta.add(ciudadACiudadDTO(c));
        }
        return respuesta;
    }

    public CiudadDTO guardarCiudad(CiudadDTO ciudad){
        LOGGER.info("Se inició una operación de guardado de la ciudad con id=: "+
                ciudad.getId());
        Ciudad ciudadAGuardar=ciudadDTOaCiudad(ciudad);
        Ciudad ciudadGuardada=ciudadRepository.save(ciudadAGuardar);
        return ciudadACiudadDTO(ciudadGuardada);
    }

    public void actualizarCiudad(CiudadDTO ciudad){
        LOGGER.info("Se inició una operación de actualización de la ciudad con id="+
                ciudad.getId());
        Ciudad ciudadAActualizar=ciudadDTOaCiudad(ciudad);
        ciudadRepository.save(ciudadAActualizar);
    }

    public void eliminarCiudad(Long id) throws ResourceNotFoundException {
        Optional<CiudadDTO> CiudadAEliminar=buscarCiudadXId(id);
        if (CiudadAEliminar.isPresent()){
            ciudadRepository.deleteById(id);
            LOGGER.warn("Se realizo una operación de eliminación de la ciudad con" +
                    "id="+id);
        }
        else{
            throw new ResourceNotFoundException("La ciudad a eliminar no existe" +
                    " en la base de datos, se intentó encontrar sin éxito en id= "+id);
        }

    }

    public Optional<CiudadDTO> buscarCiudadXId(Long id){
        LOGGER.info("Se inició una operación de búsqueda de la ciudad con id="+id);
        Optional<Ciudad> ciudadBuscada=ciudadRepository.findById(id);
        if (ciudadBuscada.isPresent()){
            return Optional.of(ciudadACiudadDTO(ciudadBuscada.get()));
        }
        else {
            return Optional.empty();
        }
    }

    private CiudadDTO ciudadACiudadDTO(Ciudad ciudad){
        CiudadDTO respuesta = new CiudadDTO();
        respuesta.setId(ciudad.getId());
        respuesta.setNombre(ciudad.getNombre());
        respuesta.setPais(ciudad.getPais());
        return respuesta;
    }

    private Ciudad ciudadDTOaCiudad(CiudadDTO ciudadDTO){
        Ciudad ciudad= new Ciudad();
        ciudad.setId(ciudadDTO.getId());
        ciudad.setNombre(ciudadDTO.getNombre());
        ciudad.setPais(ciudadDTO.getPais());
        return ciudad;
    }
}
