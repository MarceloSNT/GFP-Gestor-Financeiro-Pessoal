package projeto.gfp.dto.gestao.response;

public record GestaoResponseDto(
        Long cdGestao,
        String nmGestao,
        String nmUsuario,
        boolean flAtivo
) {
}
