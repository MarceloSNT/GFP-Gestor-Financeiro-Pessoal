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
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.gfp.dto.status.request.StatusRequestDto;
import projeto.gfp.dto.status.response.StatusResponseDto;
import projeto.gfp.dto.usuario.response.UsuarioResponseDto;
import projeto.gfp.service.StatusService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/status")
@Tag(name = "Status", description = "Gerenciamento de status")
public class StatusController {

    private final StatusService statusService;

    @PostMapping("/cadastro")
    @Operation(summary = "Cadastrar novo status", description = "Criar um novo status no sistema")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso.", content = @Content(schema = @Schema(implementation = StatusController.class))),
            @ApiResponse(responseCode = "201", description = "Recurso criado com sucesso.", content = @Content(schema = @Schema(implementation = StatusController.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida ou dados incorretos.", content = @Content),
            @ApiResponse(responseCode = "401", description = "Autenticação necessária ou token inválido.", content = @Content),
            @ApiResponse(responseCode = "403", description = "Usuário não possui permissão para acessar este recurso.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor.", content = @Content),
    })
    public ResponseEntity<StatusResponseDto> register(@Valid @RequestBody StatusRequestDto requestDto){
        StatusResponseDto status = statusService.save(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(status);
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar status", description = "Listar todos os status")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso.", content = @Content(schema = @Schema(implementation = StatusController.class))),
            @ApiResponse(responseCode = "201", description = "Recurso criado com sucesso.", content = @Content(schema = @Schema(implementation = StatusController.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida ou dados incorretos.", content = @Content),
            @ApiResponse(responseCode = "401", description = "Autenticação necessária ou token inválido.", content = @Content),
            @ApiResponse(responseCode = "403", description = "Usuário não possui permissão para acessar este recurso.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor.", content = @Content),
    })
    public ResponseEntity<List<StatusResponseDto>> findAllStatus(){
        return ResponseEntity.ok().body(statusService.findAllStatus());
    }
}
