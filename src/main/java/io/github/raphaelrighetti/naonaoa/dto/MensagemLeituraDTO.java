package io.github.raphaelrighetti.naonaoa.dto;

import java.util.List;

import io.github.raphaelrighetti.naonaoa.models.Mensagem;
import io.github.raphaelrighetti.naonaoa.models.Resposta;

public record MensagemLeituraDTO(String id, String mensagem, List<Resposta> respostas) {
	
	public MensagemLeituraDTO(Mensagem mensagem) {
		this(mensagem.getId(), mensagem.getMensagem(), mensagem.getRespostas());
	}

}
