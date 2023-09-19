package io.github.raphaelrighetti.naonaoa.mongo.dto;

import java.util.List;

import io.github.raphaelrighetti.naonaoa.mongo.models.Mensagem;
import io.github.raphaelrighetti.naonaoa.mongo.models.Resposta;

public record MensagemLeituraDTO(String id, String mensagem, List<Resposta> respostas) {
	
	public MensagemLeituraDTO(Mensagem mensagem) {
		this(mensagem.getId(), mensagem.getMensagem(), mensagem.getRespostas());
	}

}