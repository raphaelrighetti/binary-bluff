package io.github.raphaelrighetti.naonaoa.mongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.raphaelrighetti.naonaoa.mongo.models.Mensagem;
import io.github.raphaelrighetti.naonaoa.mongo.repositories.MensagemRepository;

@Service
public class AdicionarRespostaService {
	
	@Autowired
	private MensagemRepository mensagemRepository;
	
	public void adicionarResposta(Mensagem mensagem, Mensagem resposta) {
		if (mensagem.getRespostas().isEmpty()) {
			mensagem.setRespostas(List.of(resposta));
		} else if (!mensagem.getRespostas().contains(resposta)) {
			mensagem.getRespostas().add(resposta);
		}
		
		mensagem.setRespondida(true);
		
		mensagemRepository.save(mensagem);
	}

}
