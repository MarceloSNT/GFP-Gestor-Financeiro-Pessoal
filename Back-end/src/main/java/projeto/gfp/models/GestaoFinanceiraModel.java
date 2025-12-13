package projeto.gfp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TBGESTAO")
public class GestaoFinanceiraModel {
    @Column(name = "CDGESTAO")
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cdGestao;

    @Column(name = "NMTITULO")
    private String nmTitulo;

    @Column(name = "NUSALDO")
    private Double nuSaldo;

    @Column(name = "FLATIVO")
    private boolean flAtivo;

    @ManyToOne
    @JoinColumn(name = "USUARIO")
    UsuarioModel cdUsuario;
}
