package io.github.raphaelrighetti.naonaoa.mongo.dto;

import java.util.List;

import io.github.raphaelrighetti.naonaoa.mongo.models.Resposta;

public record RespostaLeituraDTO(String id, String resposta, Long usuarioId, List<String> mensagemIds) {
	
	public RespostaLeituraDTO(Resposta resposta) {
		this(resposta.getId(),
				resposta.getResposta(), 
				resposta.getUsuarioId(),
				resposta.getMensagens().stream()
				.map(mensagem -> mensagem.getId()).toList());
	}

}
