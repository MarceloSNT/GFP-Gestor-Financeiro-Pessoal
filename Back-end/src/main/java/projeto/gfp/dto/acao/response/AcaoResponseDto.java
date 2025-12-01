package projeto.gfp.dto.acao.response;

import java.time.LocalDate;

public record AcaoResponseDto(
        String dsTitulo,
        String dsDescricao,
        Double vlValor,
        LocalDate dtData,
        String cdStatus,
        String cdTipo,
        String cdGestao
) {}
