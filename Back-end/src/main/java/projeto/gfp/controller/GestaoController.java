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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projeto.gfp.dto.acao.request.AcaoRequestDto;
import projeto.gfp.dto.acao.response.AcaoResponseDto;
import projeto.gfp.dto.gestao.request.GestaoRequestDto;
import projeto.gfp.dto.gestao.response.GestaoResponseDto;
import projeto.gfp.dto.usuario.response.UsuarioResponseDto;
import projeto.gfp.service.GestaoService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/gestao")
@Tag(name = "Gestão", description = "Gerenciamento de gestão financeira")
public class GestaoController {

    private final GestaoService gestaoService;

    @PostMapping("/cadastro")
    @Operation(summary = "Cadastrar nova gestão", description = "Criar uma nova gestão no sistema")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Gestão criado com sucesso", content = @Content(schema = @Schema(implementation = UsuarioResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos", content = @Content),
    })
    public ResponseEntity<GestaoResponseDto> register(@Valid @RequestBody GestaoRequestDto requestDto){
        GestaoResponseDto gestao = gestaoService.save(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(gestao);
    }
}
