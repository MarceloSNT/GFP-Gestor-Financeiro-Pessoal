package projeto.gfp.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;
import projeto.gfp.models.UsuarioModel;
import com.auth0.jwt.algorithms.Algorithm;

import java.time.Instant;
import java.util.Optional;

@Component
public class TokenConfig {

    private final String secret = "secret";

    public String generateToken(UsuarioModel usuarioModel){
        Algorithm algorithm = Algorithm.HMAC256(secret);

        return JWT.create()
                .withClaim("cdUsuario", usuarioModel.getCdUsuario())
                .withClaim("role", usuarioModel.getROLE() != null ? usuarioModel.getROLE().name() : null)
                .withSubject(usuarioModel.getDsEmail())
                .withSubject(usuarioModel.getNmUsuario())
                .withExpiresAt(Instant.now().plusSeconds(86400))
                .withIssuedAt(Instant.now())
                .sign(algorithm);
    }

    public Optional<JWTUserData> validateToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            DecodedJWT decode = JWT.require(algorithm).build().verify(token);

            return Optional.of(JWTUserData.builder()
                    .cdUsuario(decode.getClaim("cdUsuario").asInt())
                    .dsEmail(decode.getSubject())
                    .nmUsuario(decode.getSubject())
                    .role(decode.getClaim("role").asString())
                    .build());
        }catch (JWTVerificationException ex){
            return Optional.empty();
        }
    }
}
