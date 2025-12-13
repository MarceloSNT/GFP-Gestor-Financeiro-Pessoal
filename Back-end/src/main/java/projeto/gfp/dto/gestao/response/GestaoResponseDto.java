package projeto.gfp.dto.gestao.response;

public record GestaoResponseDto(
        Long cdGestao,
        String nmTitulo,
        Double nuSaldo,
        String nmUsuario,
        boolean flAtivo
) {
}
