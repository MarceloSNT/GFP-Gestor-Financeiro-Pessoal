package projeto.gfp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import projeto.gfp.dto.auth.request.LoginRequestDto;
import projeto.gfp.dto.auth.response.LoginResponseDto;
import projeto.gfp.dto.usuario.request.UsuarioRequestDto;
import projeto.gfp.dto.usuario.response.UsuarioResponseDto;
import projeto.gfp.models.UsuarioModel;
import projeto.gfp.repository.UsuarioRepository;
import projeto.gfp.security.TokenConfig;
import projeto.gfp.service.UsuarioService;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
@Tag(name = "Autenticação", description = "Endpoints de auntenticação e registro de usuário")
@CrossOrigin(origins = "*")
public class AuthController {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioService usuarioService;
    private final TokenConfig tokenConfig;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/login")
    @Operation(summary = "Login de usuário", description = "Realizar login de usuário e retornar um token JWT")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso.", content = @Content(schema = @Schema(implementation = UsuarioResponseDto.class))),
            @ApiResponse(responseCode = "201", description = "Recurso criado com sucesso.", content = @Content(schema = @Schema(implementation = UsuarioResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida ou dados incorretos.", content = @Content),
            @ApiResponse(responseCode = "401", description = "Autenticação necessária ou token inválido.", content = @Content),
            @ApiResponse(responseCode = "403", description = "Usuário não possui permissão para acessar este recurso.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor.", content = @Content),
    })
    public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginRequestDto loginRequest){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.dsEmail(), loginRequest.dsSenha());
        authenticationManager.authenticate(authenticationToken);

        UsuarioModel usuario = usuarioRepository.findByDsEmail(loginRequest.dsEmail()).orElseThrow();
        String token  = tokenConfig.generateToken(usuario);

        return ResponseEntity.ok(new LoginResponseDto(
                token,
                usuario.getNmUsuario(),
                usuario.getCdUsuario(),
                usuario.getDsEmail(),
                usuario.getROLE()
        ));
    }

    @PostMapping("/registro")
    @Operation(summary = "Registro de usuário", description = "Realizar registro de novo usuário")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso.", content = @Content(schema = @Schema(implementation = UsuarioResponseDto.class))),
            @ApiResponse(responseCode = "201", description = "Recurso criado com sucesso.", content = @Content(schema = @Schema(implementation = UsuarioResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida ou dados incorretos.", content = @Content),
            @ApiResponse(responseCode = "401", description = "Autenticação necessária ou token inválido.", content = @Content),
            @ApiResponse(responseCode = "403", description = "Usuário não possui permissão para acessar este recurso.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor.", content = @Content),
    })
    public ResponseEntity<UsuarioResponseDto> registro(@Valid @RequestBody UsuarioRequestDto usuarioRequest){
        UsuarioResponseDto criarUsuario =  usuarioService.save(usuarioRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(criarUsuario);
    }
}
