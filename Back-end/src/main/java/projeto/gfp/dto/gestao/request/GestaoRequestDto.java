package projeto.gfp.dto.gestao.request;

import jakarta.validation.constraints.NotNull;

public record GestaoRequestDto(
        @NotNull(message = "Nome é obrigatório")
        String nmTitulo,

        @NotNull(message = "Código de usuário é obrigatório")
        Long cdUsuario,

        boolean flAtivo
) {}
