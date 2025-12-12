package projeto.gfp.dto.auth.response;

import projeto.gfp.Role;

public record LoginResponseDto(
        String token,
        Long cdUsuario,
        String dsEmail,
        Role role
) {
}
