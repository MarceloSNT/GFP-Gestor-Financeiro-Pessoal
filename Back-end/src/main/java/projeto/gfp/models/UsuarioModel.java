package projeto.gfp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import projeto.gfp.Role;

import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TBUSUARIO")
public class UsuarioModel implements UserDetails {

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

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (ROLE == null) return List.of();
        return List.of(new SimpleGrantedAuthority("ROLE_" + ROLE.name()));
    }

    @Override
    public String getPassword() {
        return dsSenha;
    }

    @Override
    public String getUsername() {
        return dsEmail;
    }
}
