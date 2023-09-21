package io.github.raphaelrighetti.naonaoa.mongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.raphaelrighetti.naonaoa.mongo.models.Mensagem;
import io.github.raphaelrighetti.naonaoa.mongo.models.Resposta;
import io.github.raphaelrighetti.naonaoa.mongo.repositories.MensagemRepository;

@Service
public class MensagemAdicionarRespostaService {
	
	@Autowired
	private MensagemRepository repository;
	
	public void adicionarResposta(Mensagem mensagem, Resposta resposta) {
		if (mensagem.getRespostas().isEmpty()) {
			mensagem.setRespostas(List.of(resposta));
		} else {
			mensagem.getRespostas().add(resposta);
		}
		
		mensagem.setRespondida(true);
		
		repository.save(mensagem);
	}

}
