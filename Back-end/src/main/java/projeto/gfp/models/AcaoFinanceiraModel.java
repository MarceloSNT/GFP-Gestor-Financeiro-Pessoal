package projeto.gfp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TBACAO")
public class AcaoFinanceiraModel {
    @Column(name = "CDACAO")
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cdAcao;

    @Column(name = "DSTITULO")
    private String dsTitulo;

    @Column(name = "DSDESCRICAO")
    private String dsDescricao;

    @Column(name = "VLVALOR")
    private Double vlValor;

    @Column(name = "DTDATA")
    private LocalDate dtData;

    @Column(name = "FLATIVO")
    private boolean flAtivo;

    @ManyToOne
    @JoinColumn(name = "STATUS")
    StatusModel cdStatus;

    @ManyToOne
    @JoinColumn(name = "TIPO")
    TipoModel cdTipo;

    @ManyToOne
    @JoinColumn(name = "GESTAO")
    GestaoFinanceiraModel cdGestao;

}
