package projeto.gfp.dto.auth.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LoginRequestDto(
   @NotBlank
   String dsEmail,
   @NotBlank
   String dsSenha
) {}
