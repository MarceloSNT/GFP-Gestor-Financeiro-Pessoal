package projeto.gfp.dto.usuario.response;

import projeto.gfp.Role;

public record UsuarioResponseListarDto(
        String nmUsuario,
        String dsEmail,
        Role role
) {
}
