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
import projeto.gfp.dto.gestao.request.GestaoRequestDto;
import projeto.gfp.dto.gestao.response.GestaoResponseDto;
import projeto.gfp.dto.usuario.response.UsuarioResponseDto;
import projeto.gfp.service.GestaoService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/gestao")
@Tag(name = "Gestão", description = "Gerenciamento de gestão financeira")
public class GestaoController {

    private final GestaoService gestaoService;

    @PostMapping("/cadastro")
    @Operation(summary = "Cadastrar nova gestão", description = "Criar uma nova gestão no sistema")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso.", content = @Content(schema = @Schema(implementation = GestaoController.class))),
            @ApiResponse(responseCode = "201", description = "Recurso criado com sucesso.", content = @Content(schema = @Schema(implementation = GestaoController.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida ou dados incorretos.", content = @Content),
            @ApiResponse(responseCode = "401", description = "Autenticação necessária ou token inválido.", content = @Content),
            @ApiResponse(responseCode = "403", description = "Usuário não possui permissão para acessar este recurso.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor.", content = @Content),
    })
    public ResponseEntity<GestaoResponseDto> register(@Valid @RequestBody GestaoRequestDto requestDto){
        GestaoResponseDto gestao = gestaoService.save(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(gestao);
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar gestões", description = "Listar todas gestões no sistema")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso.", content = @Content(schema = @Schema(implementation = GestaoController.class))),
            @ApiResponse(responseCode = "201", description = "Recurso criado com sucesso.", content = @Content(schema = @Schema(implementation = GestaoController.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida ou dados incorretos.", content = @Content),
            @ApiResponse(responseCode = "401", description = "Autenticação necessária ou token inválido.", content = @Content),
            @ApiResponse(responseCode = "403", description = "Usuário não possui permissão para acessar este recurso.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor.", content = @Content),
    })
    public ResponseEntity<List<GestaoResponseDto>> findAllManagements(){
        return ResponseEntity.ok().body(gestaoService.findAllManagement());
    }

    @PutMapping("/desativar/ativar")
    @Operation(summary = "Alterar flAtivo de Gestão", description = "Alterar o flAtivo de gestão no sistema")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso.", content = @Content(schema = @Schema(implementation = AcaoController.class))),
            @ApiResponse(responseCode = "201", description = "Recurso criado com sucesso.", content = @Content(schema = @Schema(implementation = AcaoController.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida ou dados incorretos.", content = @Content),
            @ApiResponse(responseCode = "401", description = "Autenticação necessária ou token inválido.", content = @Content),
            @ApiResponse(responseCode = "403", description = "Usuário não possui permissão para acessar este recurso.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor.", content = @Content),
    })
    public ResponseEntity<GestaoResponseDto> offOrOnFlAtivo(@RequestParam Long cdGestao) {
        GestaoResponseDto gestao = gestaoService.offOrOnFlAtivo(cdGestao);
        return ResponseEntity.status(HttpStatus.OK).body(gestao);
    }
}
