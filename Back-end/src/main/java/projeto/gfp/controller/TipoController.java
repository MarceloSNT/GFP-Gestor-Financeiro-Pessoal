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
import projeto.gfp.dto.tipo.request.TipoRequestDto;
import projeto.gfp.dto.tipo.response.TipoResponseDto;
import projeto.gfp.dto.usuario.response.UsuarioResponseDto;
import projeto.gfp.models.TipoModel;
import projeto.gfp.service.TipoService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tipo")
@Tag(name = "Tipo", description = "Gerenciamento de tipo")
public class TipoController {

    private final TipoService tipoService;

    @PostMapping("/cadastro")
    @Operation(summary = "Cadastrar novo tipo", description = "Criar um novo tipo no sistema")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Tipo criado com sucesso", content = @Content(schema = @Schema(implementation = UsuarioResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos", content = @Content),
    })
    public ResponseEntity<TipoResponseDto> register(@Valid @RequestBody TipoRequestDto requestDto){
        TipoResponseDto tipo = tipoService.save(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(tipo);
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar tipos", description = "Listar todos os tipos")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Tipos encontrados com sucesso", content = @Content(schema = @Schema(implementation = UsuarioResponseDto.class))),
    })
    public ResponseEntity<List<TipoResponseDto>> findAllType(){
        return ResponseEntity.ok().body(tipoService.findAllType());
    }
}
