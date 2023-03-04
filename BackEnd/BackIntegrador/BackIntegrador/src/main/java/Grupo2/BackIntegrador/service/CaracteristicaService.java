package Grupo2.BackIntegrador.service;

import Grupo2.BackIntegrador.DTO.CaracteristicaDTO;
import Grupo2.BackIntegrador.Exception.ResourceNotFoundException;
import Grupo2.BackIntegrador.model.Caracteristica;
import Grupo2.BackIntegrador.repository.CaracteristicaRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CaracteristicaService {

    private CaracteristicaRepository caracteristicaRepository;
    private static final Logger LOGGER=Logger.getLogger(CaracteristicaService.class);
    @Autowired
    public CaracteristicaService(CaracteristicaRepository caracteristicaRepository) {

        this.caracteristicaRepository = caracteristicaRepository;
    }

    public List<CaracteristicaDTO> listarCaracteristica() {
        LOGGER.info("Se inició el listado de todas las Caracteristicas");
        List<Caracteristica>caracteristicasEncontradas=caracteristicaRepository.findAll();
        List<CaracteristicaDTO> respuesta= new ArrayList<>();
        for (Caracteristica c:caracteristicasEncontradas){
            respuesta.add(caracteristicaACaracteristicaDTO(c));
        }
        return respuesta;
    }

    public CaracteristicaDTO guardarCaracteristica(CaracteristicaDTO caracteristica){
        LOGGER.info("Se inició una operación de guardado de la Caracteristicas con titulo: "+
                caracteristica.getTitulo());
        Caracteristica caracteristicaAGuardar=caracteristicaDTOaCaracteristica(caracteristica);
        Caracteristica caracteristicaGuardada=caracteristicaRepository.save(caracteristicaAGuardar);
        return caracteristicaACaracteristicaDTO(caracteristicaGuardada);
    }

    public void actualizarCaracteristica(CaracteristicaDTO caracteristica){
        LOGGER.info("Se inició una operación de actualización de la Caracteristica con id="+
                caracteristica.getId());
        Caracteristica caracteristicaAActualizar=caracteristicaDTOaCaracteristica(caracteristica);
        caracteristicaRepository.save(caracteristicaAActualizar);
    }

    public void eliminarCaracteristica(Long id) throws ResourceNotFoundException {
        Optional<CaracteristicaDTO> caracteristicaAEliminar=buscarCaracteristicaXId(id);
        if (caracteristicaAEliminar.isPresent()){
            caracteristicaRepository.deleteById(id);
            LOGGER.warn("Se realizo una operación de eliminación de la Caracteristica con" +
                    "id="+id);
        }
        else{
            throw new ResourceNotFoundException("La Caracteristica a eliminar no existe" +
                    " en la base de datos, se intentó encontrar sin éxito en id= "+id);
        }

    }

    public Optional<CaracteristicaDTO> buscarCaracteristicaXId(Long id){
        LOGGER.info("Se inició una operación de búsqueda de la Caracteristica con id="+id);
        Optional<Caracteristica> caracteristicaBuscada= caracteristicaRepository.findById(id);
        if (caracteristicaBuscada.isPresent()){
            return Optional.of(caracteristicaACaracteristicaDTO(caracteristicaBuscada.get()));
        }
        else {
            return Optional.empty();
        }
    }

    private CaracteristicaDTO caracteristicaACaracteristicaDTO(Caracteristica caracteristica){
        CaracteristicaDTO respuesta = new CaracteristicaDTO();
        respuesta.setId(caracteristica.getId());
        respuesta.setTitulo(caracteristica.getTitulo());
        respuesta.setIcono(caracteristica.getIcono());
        return respuesta;
    }

    private Caracteristica caracteristicaDTOaCaracteristica(CaracteristicaDTO caracteristicaDTO){
        Caracteristica caracteristica = new Caracteristica();
        caracteristica.setId(caracteristicaDTO.getId());
        caracteristica.setTitulo(caracteristicaDTO.getTitulo());
        caracteristica.setIcono(caracteristicaDTO.getIcono());
        return caracteristica;
    }
}