package io.github.raphaelrighetti.naonaoa.mongo.dto;

import java.util.List;

import io.github.raphaelrighetti.naonaoa.mongo.models.Mensagem;
import io.github.raphaelrighetti.naonaoa.mongo.models.Resposta;

public record MensagemLeituraDTO(String id, String mensagem, Boolean respondida, List<String> respostaIds) {
	
	public MensagemLeituraDTO(Mensagem mensagem) {
		this(mensagem.getId(), 
				mensagem.getMensagem(),
				mensagem.getRespondida(),
				mensagem.getRespostas().stream()
				.map(Resposta::getId).toList());
	}

}
