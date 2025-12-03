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
import projeto.gfp.dto.acao.request.AcaoRequestDto;
import projeto.gfp.dto.acao.response.AcaoResponseDto;
import projeto.gfp.dto.usuario.request.UsuarioRequestDto;
import projeto.gfp.dto.usuario.response.UsuarioResponseDto;
import projeto.gfp.service.AcaoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/acao")
@Tag(name = "Ações", description = "Gerenciamento de ações financeiras")
public class AcaoController {

    private final AcaoService acaoService;

    @PostMapping("/cadastro")
    @Operation(summary = "Cadastrar nova ação", description = "Criar uma nova ação no sistema")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso.", content = @Content(schema = @Schema(implementation = AcaoController.class))),
            @ApiResponse(responseCode = "201", description = "Recurso criado com sucesso.", content = @Content(schema = @Schema(implementation = AcaoController.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida ou dados incorretos.", content = @Content),
            @ApiResponse(responseCode = "401", description = "Autenticação necessária ou token inválido.", content = @Content),
            @ApiResponse(responseCode = "403", description = "Usuário não possui permissão para acessar este recurso.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor.", content = @Content),
    })
    public ResponseEntity<AcaoResponseDto> register(@Valid @RequestBody AcaoRequestDto requestDto){
        AcaoResponseDto acao = acaoService.save(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(acao);
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar ações", description = "Listar todoas as ações ativas")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso.", content = @Content(schema = @Schema(implementation = AcaoController.class))),
            @ApiResponse(responseCode = "201", description = "Recurso criado com sucesso.", content = @Content(schema = @Schema(implementation = AcaoController.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida ou dados incorretos.", content = @Content),
            @ApiResponse(responseCode = "401", description = "Autenticação necessária ou token inválido.", content = @Content),
            @ApiResponse(responseCode = "403", description = "Usuário não possui permissão para acessar este recurso.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor.", content = @Content),
    })
    public ResponseEntity<List<AcaoResponseDto>> findAll(){
        return ResponseEntity.ok().body(acaoService.findAllAction());
    }

    @PutMapping("/desativar/ativar")
    @Operation(summary = "Alterar flAtivo de usuário", description = "Alterar o flAtivo de usuário no sistema")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso.", content = @Content(schema = @Schema(implementation = AcaoController.class))),
            @ApiResponse(responseCode = "201", description = "Recurso criado com sucesso.", content = @Content(schema = @Schema(implementation = AcaoController.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida ou dados incorretos.", content = @Content),
            @ApiResponse(responseCode = "401", description = "Autenticação necessária ou token inválido.", content = @Content),
            @ApiResponse(responseCode = "403", description = "Usuário não possui permissão para acessar este recurso.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor.", content = @Content),
    })
    public ResponseEntity<AcaoResponseDto> offOrOnFlAtivo(@RequestParam Long cdAcao){
        AcaoResponseDto acao = acaoService.offOrOnFlAtivo(cdAcao);
        return ResponseEntity.status(HttpStatus.OK).body(acao);
    }

    @GetMapping("/listar/gestao")
    @Operation(summary = "Listar ações", description = "Listar todoas as ações ativas de uma gestão especifíca")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso.", content = @Content(schema = @Schema(implementation = AcaoController.class))),
            @ApiResponse(responseCode = "201", description = "Recurso criado com sucesso.", content = @Content(schema = @Schema(implementation = AcaoController.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida ou dados incorretos.", content = @Content),
            @ApiResponse(responseCode = "401", description = "Autenticação necessária ou token inválido.", content = @Content),
            @ApiResponse(responseCode = "403", description = "Usuário não possui permissão para acessar este recurso.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor.", content = @Content),
    })
    public List<AcaoResponseDto> findByGestao(@RequestParam Long cdGestao){
        return acaoService.findByGestao(cdGestao);
    }
}
