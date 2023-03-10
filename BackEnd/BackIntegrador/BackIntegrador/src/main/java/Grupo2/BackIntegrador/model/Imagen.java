package Grupo2.BackIntegrador.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
@Table(name="imagen")
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String titulo;
    @Column
    private String url_img;

    @ManyToOne
    @JsonIncludeProperties("id")
    private Producto producto;

    public Imagen(Long id, String titulo, String url_img) {
        this.id = id;
        this.titulo = titulo;
        this.url_img = url_img;
    }
}
