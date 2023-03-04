package Grupo2.BackIntegrador.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioDTO {

    private Long id;
    private String nombre;
    private String email;
    private String contraseña;

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "id=" + id +
                ", nombre='" + nombre +
                ", email='" + email +
                ", contraseña='" + contraseña +
                '}';
    }
}
