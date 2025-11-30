package projeto.gfp.dto.usuario.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import projeto.gfp.Role;

public record UsuarioRequestDto(
        @NotNull(message = "Nome é obrigatório")
        String nmUsuario,

        @NotNull(message = "E-mail é obrigatório")
        @Email(message = "E-mail inválido")
        String dsEmail,

        @NotNull(message = "Senha é obrigatório")
        @Size(min = 6, max = 20, message = "A senha deve ter entre 6 e 20 caracteres")
        @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$.%^&+=]).*$",
                message = "A senha deve conter pelo menos uma letra maiúscula, uma minúscula, um número e um caractere especial : @#$.%^&+=")
        String dsSenha,

        @NotNull(message = "O status ativo é obrigatório")
        boolean flAtivo,

        Role role
) {
}
