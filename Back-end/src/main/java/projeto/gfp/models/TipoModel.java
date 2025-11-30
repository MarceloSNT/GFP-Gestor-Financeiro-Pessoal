package projeto.gfp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TBTIPO")
public class TipoModel {
    @Column(name = "CDTIPO")
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cdTipo;

    @Column(name = "NMTIPO")
    private String nmTipo;
}
