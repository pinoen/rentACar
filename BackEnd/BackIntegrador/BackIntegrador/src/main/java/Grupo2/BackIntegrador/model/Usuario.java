package Grupo2.BackIntegrador.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column(nullable = false, unique = true)
    private String userName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column
    private String ciudad;

    @Column
    private boolean verificado;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_roles",
                joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "roles_id", referencedColumnName = "id")
    )
    private Set<Roles> roles = new HashSet<>();

    @OneToMany(mappedBy = "usuario", cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REMOVE} , fetch = FetchType.EAGER)
    @JsonIgnoreProperties("usuario")
    private Set<Reserva> reserva= new HashSet<>();

    @OneToMany(mappedBy = "usuario", cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REMOVE} , fetch = FetchType.EAGER)
    @JsonIgnoreProperties("usuario")
    private Set<Puntuacion> puntuacion= new HashSet<>();

    public void removeReserva ( Reserva reserva){
        this.reserva.remove(reserva);
        reserva.setUsuario(null);
    }

    public void removePuntuacion(Puntuacion puntuacion){
        this.puntuacion.remove(puntuacion);
        puntuacion.setUsuario(null);
    }
}
