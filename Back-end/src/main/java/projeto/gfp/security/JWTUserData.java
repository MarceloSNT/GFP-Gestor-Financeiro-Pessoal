package projeto.gfp.security;

import lombok.Builder;

@Builder
public record JWTUserData(
        Integer cdUsuario,
        String dsEmail,
        String role
){}
