package projeto.gfp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.gfp.dto.usuario.request.UsuarioRequestDto;
import projeto.gfp.dto.usuario.response.UsuarioResponseDto;
import projeto.gfp.dto.usuario.response.UsuarioResponseListarDto;
import projeto.gfp.models.UsuarioModel;
import projeto.gfp.service.UsuarioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/usuario")
@Tag(name = "Usuário", description = "Gerenciamento de usuários")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/cadastro")
    @Operation(summary = "Cadastrar novo usuário", description = "Criar um novo usuário no sistema")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso.", content = @Content(schema = @Schema(implementation = UsuarioResponseDto.class))),
            @ApiResponse(responseCode = "201", description = "Recurso criado com sucesso.", content = @Content(schema = @Schema(implementation = UsuarioResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida ou dados incorretos.", content = @Content),
            @ApiResponse(responseCode = "401", description = "Autenticação necessária ou token inválido.", content = @Content),
            @ApiResponse(responseCode = "403", description = "Usuário não possui permissão para acessar este recurso.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor.", content = @Content),
    })
    public ResponseEntity<UsuarioResponseDto> register(@Valid @RequestBody UsuarioRequestDto requestDto){
        UsuarioResponseDto usuario = usuarioService.save(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @PutMapping("/desativar/ativar")
    @Operation(summary = "Alterar flAtivo de usuário", description = "Alterar o flAtivo de usuário no sistema")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso.", content = @Content(schema = @Schema(implementation = UsuarioResponseDto.class))),
            @ApiResponse(responseCode = "201", description = "Recurso criado com sucesso.", content = @Content(schema = @Schema(implementation = UsuarioResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida ou dados incorretos.", content = @Content),
            @ApiResponse(responseCode = "401", description = "Autenticação necessária ou token inválido.", content = @Content),
            @ApiResponse(responseCode = "403", description = "Usuário não possui permissão para acessar este recurso.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor.", content = @Content),
    })
    public ResponseEntity<UsuarioResponseDto> offOrOnFlAtivo(@RequestParam String dsEmail){
        UsuarioResponseDto usuario = usuarioService.offOrOnFlAtivo(dsEmail);
        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar usuários", description = "Listar todos os usuários ativos")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso.", content = @Content(schema = @Schema(implementation = UsuarioResponseDto.class))),
            @ApiResponse(responseCode = "201", description = "Recurso criado com sucesso.", content = @Content(schema = @Schema(implementation = UsuarioResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida ou dados incorretos.", content = @Content),
            @ApiResponse(responseCode = "401", description = "Autenticação necessária ou token inválido.", content = @Content),
            @ApiResponse(responseCode = "403", description = "Usuário não possui permissão para acessar este recurso.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor.", content = @Content),
    })
    public ResponseEntity<List<UsuarioResponseListarDto>> findAll(){
        return ResponseEntity.ok().body(usuarioService.findAllUser());
    }

    @GetMapping("/listar/código")
    @Operation(summary = "Lista usuário", description = "Lista usuário pelo código")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso.", content = @Content(schema = @Schema(implementation = UsuarioResponseDto.class))),
            @ApiResponse(responseCode = "201", description = "Recurso criado com sucesso.", content = @Content(schema = @Schema(implementation = UsuarioResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida ou dados incorretos.", content = @Content),
            @ApiResponse(responseCode = "401", description = "Autenticação necessária ou token inválido.", content = @Content),
            @ApiResponse(responseCode = "403", description = "Usuário não possui permissão para acessar este recurso.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor.", content = @Content),
    })
    public Optional<UsuarioResponseDto> findById(@RequestParam Long cdUsuario){
        return usuarioService.findById(cdUsuario);
    }

    @GetMapping("/listar/email")
    @Operation(summary = "Lista usuário", description = "Lista usuário pelo email")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso.", content = @Content(schema = @Schema(implementation = UsuarioResponseDto.class))),
            @ApiResponse(responseCode = "201", description = "Recurso criado com sucesso.", content = @Content(schema = @Schema(implementation = UsuarioResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida ou dados incorretos.", content = @Content),
            @ApiResponse(responseCode = "401", description = "Autenticação necessária ou token inválido.", content = @Content),
            @ApiResponse(responseCode = "403", description = "Usuário não possui permissão para acessar este recurso.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor.", content = @Content),
    })
    public Optional<UsuarioResponseDto> findByEmail(@RequestParam String dsEmail){
        return usuarioService.findByEmail(dsEmail);
    }
}
