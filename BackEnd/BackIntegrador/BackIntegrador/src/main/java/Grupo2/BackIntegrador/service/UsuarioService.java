package Grupo2.BackIntegrador.service;

import Grupo2.BackIntegrador.DTO.UsuarioDTO;
import Grupo2.BackIntegrador.model.Usuario;
import Grupo2.BackIntegrador.repository.UsuarioRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService{
    private UsuarioRepository usuarioRepository;

    private static final Logger LOGGER = Logger.getLogger(UsuarioService.class);

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {

        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioDTO guardarUsuario (UsuarioDTO usuario){
        LOGGER.info("Se inicio el guardado de un usuario");
        Usuario usuarioAGuardar= usuarioDTOaUsuario(usuario);
        Usuario usuarioGuardado= usuarioRepository.save(usuarioAGuardar);
        return usuarioAUsuarioDTO(usuarioGuardado);
    }
    public void eliminarUsuario(Long id){
        LOGGER.warn("Se inicio la eliminación de un usuario con id= "+id);
        usuarioRepository.deleteById(id);
    }
    public void actualizarUsuario(UsuarioDTO usuario){
        LOGGER.info("Se inicio la actualización de un usuario con id= "+usuario.getId());
        Usuario usuarioAActualizar=usuarioDTOaUsuario(usuario);
        usuarioRepository.save(usuarioAActualizar);
    }
    public Optional<UsuarioDTO> buscarUsuario(Long id){
        LOGGER.info("Se inicio la búsqueda de un usuario con el id= "+id);
        Optional<Usuario> usuarioBuscado=usuarioRepository.findById(id);
        if (usuarioBuscado.isPresent()){
            return Optional.of(usuarioAUsuarioDTO(usuarioBuscado.get()));
        }
        else{
            return Optional.empty();
        }
    }
    public List<UsuarioDTO> buscarTodosLosUsuarios(){
        LOGGER.info("Se inicio la búsqueda de todos los usuarios");
        List<Usuario>usuariosEncontrados=usuarioRepository.findAll();
        List<UsuarioDTO> respuesta=new ArrayList<>();
        for (Usuario u:usuariosEncontrados){
            respuesta.add(usuarioAUsuarioDTO(u));
        }
        return respuesta;
    }

    private UsuarioDTO usuarioAUsuarioDTO(Usuario usuario){
        UsuarioDTO respuesta= new UsuarioDTO();
        respuesta.setId(usuario.getId());
        respuesta.setNombre(usuario.getNombre());
        respuesta.setEmail(usuario.getEmail());
        respuesta.setContraseña(usuario.getContraseña());
        return respuesta;
    }

    private Usuario usuarioDTOaUsuario(UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario();
        usuario.setId(usuarioDTO.getId());
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setContraseña(usuarioDTO.getContraseña());
        return usuario;
    }
}
