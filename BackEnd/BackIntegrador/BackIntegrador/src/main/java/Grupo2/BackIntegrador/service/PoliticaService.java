package Grupo2.BackIntegrador.service;

import Grupo2.BackIntegrador.DTO.PoliticaDTO;
import Grupo2.BackIntegrador.Exception.ResourceNotFoundException;

import Grupo2.BackIntegrador.model.Politica;
import Grupo2.BackIntegrador.repository.PoliticaRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PoliticaService {

    private PoliticaRepository politicaRepository;
    private static final Logger LOGGER=Logger.getLogger(PoliticaService.class);
    @Autowired
    public PoliticaService(PoliticaService politicaService) {

        this.politicaRepository = politicaRepository;
    }

    public List<PoliticaDTO> listarPoliticas() {
        LOGGER.info("Se inició el listado de todas las Politicas");
        List<Politica>politicasEncontradas=politicaRepository.findAll();
        List<PoliticaDTO> respuesta= new ArrayList<>();
        for (Politica p:politicasEncontradas){
            respuesta.add(politicaAPoliticaDTO(p));
        }
        return respuesta;
    }

    public PoliticaDTO guardarPolitica(PoliticaDTO politica){
        LOGGER.info("Se inició una operación de guardado de la politica con titulo: "+
                politica.getTitulo());
        Politica politicaAGuardar=politicaDTOaPolitica(politica);
        Politica politicaGuardada=politicaRepository.save(politicaAGuardar);
        return politicaAPoliticaDTO(politicaGuardada);
    }

    public void actualizarPolitica(PoliticaDTO politica){
        LOGGER.info("Se inició una operación de actualización de la politica con id="+
                politica.getId());
        Politica politicaAActualizar=politicaDTOaPolitica(politica);
        politicaRepository.save(politicaAActualizar);
    }

    public void eliminarPolitica(Long id) throws ResourceNotFoundException {
        Optional<PoliticaDTO> politicaAEliminar=buscarPoliticaXId(id);
        if (politicaAEliminar.isPresent()){
            politicaRepository.deleteById(id);
            LOGGER.warn("Se realizo una operación de eliminación de la politica con" +
                    "id="+id);
        }
        else{
            throw new ResourceNotFoundException("La politica a eliminar no existe" +
                    " en la base de datos, se intentó encontrar sin éxito en id= "+id);
        }

    }

    public Optional<PoliticaDTO> buscarPoliticaXId(Long id){
        LOGGER.info("Se inició una operación de búsqueda de la politica con id="+id);
        Optional<Politica> politicaBuscada=politicaRepository.findById(id);
        if (politicaBuscada.isPresent()){
            return Optional.of(politicaAPoliticaDTO(politicaBuscada.get()));
        }
        else {
            return Optional.empty();
        }
    }

    private PoliticaDTO politicaAPoliticaDTO(Politica politica){
        PoliticaDTO respuesta=new PoliticaDTO();
        respuesta.setId(politica.getId());
        respuesta.setTitulo(politica.getTitulo());
        respuesta.setDescripcion(politica.getDescripcion());
        return respuesta;
    }

    private Politica politicaDTOaPolitica(PoliticaDTO politicaDTO){
        Politica politica= new Politica();
        politica.setId(politicaDTO.getId());
        politica.setTitulo(politicaDTO.getTitulo());
        politica.setDescripcion(politicaDTO.getDescripcion());
        return politica;
    }
}