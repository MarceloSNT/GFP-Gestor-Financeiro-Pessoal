package projeto.gfp.dto.acao.request;

import java.time.LocalDate;

public record AcaoRequestDto(
        String dsTitulo,
        String dsDescricao,
        Double vlValor,
        LocalDate dtData,
        Boolean flAtivo,
        Long cdStatus,
        Long cdTipo,
        Long cdGestao

) {}
