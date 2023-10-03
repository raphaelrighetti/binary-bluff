package io.github.raphaelrighetti.naonaoa.mongo.dto;

import java.util.List;

import io.github.raphaelrighetti.naonaoa.mongo.models.Mensagem;

public record MensagemLeituraDTO(String id, String mensagem, Boolean respondida, List<String> respostasIds) {
	
	public MensagemLeituraDTO(Mensagem mensagem) {
		this(mensagem.getId(), 
				mensagem.getMensagem(),
				mensagem.getRespondida(),
				mensagem.getRespostas()
				.stream()
				.map(Mensagem::getId)
				.toList());
	}

}
