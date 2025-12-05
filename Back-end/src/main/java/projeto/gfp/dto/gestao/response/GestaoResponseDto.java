package projeto.gfp.dto.gestao.response;

public record GestaoResponseDto(
        Long cdGestao,
        String nmTitulo,
        String nmUsuario,
        boolean flAtivo
) {
}
