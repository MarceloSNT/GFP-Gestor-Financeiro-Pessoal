package projeto.gfp.dto.usuario.response;

import projeto.gfp.Role;

public record UsuarioResponseDto(
        String nmUsuario,
        String dsEmail,
        boolean flAtivo,
        Role role
) {
}
