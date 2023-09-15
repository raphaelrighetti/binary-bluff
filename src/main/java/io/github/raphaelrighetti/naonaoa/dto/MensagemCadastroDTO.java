package io.github.raphaelrighetti.naonaoa.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record MensagemCadastroDTO(@NotBlank @Size(min = 3) String mensagem) {

}
