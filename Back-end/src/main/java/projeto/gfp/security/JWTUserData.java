package projeto.gfp.security;

import lombok.Builder;

@Builder
public record JWTUserData(
        Integer cdUsuario,
        String nmUsuario,
        String dsEmail,
        String role
){}
