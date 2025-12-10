package projeto.gfp.dto.acao.response;

import java.time.LocalDate;
import java.util.Date;

public record AcaoResponseDto(
        String dsTitulo,
        String dsDescricao,
        Double vlValor,
        Date dtData,
        String cdStatus,
        String cdTipo,
        String cdGestao
) {}
