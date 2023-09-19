package io.github.raphaelrighetti.naonaoa.mongo.dto;

import io.github.raphaelrighetti.naonaoa.mongo.models.Resposta;

public record RespostaLeituraDTO(String id, String resposta, String mensagemId, Long usuarioId) {
	
	public RespostaLeituraDTO(Resposta resposta) {
		this(resposta.getId(), resposta.getResposta(), 
				resposta.getMensagem().getId(), resposta.getUsuarioId());
	}

}
