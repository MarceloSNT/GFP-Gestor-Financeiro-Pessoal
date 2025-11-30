package projeto.gfp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import projeto.gfp.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TBUSUARIO")
public class UsuarioModel {

    @Column(name = "CDUSUARIO")
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cdUsuario;

    @Column(name = "NMUSUARIO")
    private String nmUsuario;

    @Column(name = "DSEMAIL")
    private String dsEmail;

    @Column(name = "DSSENHA")
    private String dsSenha;

    @Column(name = "FLATIVO")
    private boolean flAtivo;

    @Column(name = "ROLE")
    private Role ROLE;
}
