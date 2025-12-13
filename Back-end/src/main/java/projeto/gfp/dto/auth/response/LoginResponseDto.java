package projeto.gfp.dto.auth.response;

import projeto.gfp.Role;

public record LoginResponseDto(
        String token,
        String nmUsuario,
        Long cdUsuario,
        String dsEmail,
        Role role
) {
}
