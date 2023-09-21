package io.github.raphaelrighetti.naonaoa.mongo.dto;

import jakarta.validation.constraints.NotBlank;

public record RespostaAdicionarMensagemDTO(@NotBlank String mensagemId) {

}
