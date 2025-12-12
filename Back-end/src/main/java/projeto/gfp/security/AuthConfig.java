package projeto.gfp.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import projeto.gfp.repository.UsuarioRepository;

@AllArgsConstructor
@Service
public class AuthConfig implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByDsEmail(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
