package projeto.gfp.dto.acao.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

public record AcaoRequestDto(
        String dsTitulo,
        String dsDescricao,
        Double vlValor,
        Date dtData,
        Boolean flAtivo,
        Long cdStatus,
        Long cdTipo,
        Long cdGestao

) {}
