package io.github.raphaelrighetti.naonaoa.mongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.raphaelrighetti.naonaoa.mongo.models.Mensagem;
import io.github.raphaelrighetti.naonaoa.mongo.models.Resposta;
import io.github.raphaelrighetti.naonaoa.mongo.repositories.MensagemRepository;
import io.github.raphaelrighetti.naonaoa.mongo.repositories.RespostaRepository;

@Service
public class AdicionarRespostaService {
	
	@Autowired
	private MensagemRepository mensagemRepository;
	
	@Autowired
	private RespostaRepository respostaRepository;
	
	public void adicionarResposta(Mensagem mensagem, Resposta resposta) {
		if (mensagem.getRespostas().isEmpty()) {
			mensagem.setRespostas(List.of(resposta));
		} else {
			mensagem.getRespostas().add(resposta);
		}
		
		if (resposta.getMensagens().isEmpty()) {
			resposta.setMensagens(List.of(mensagem));
		} else if (!resposta.getMensagens().contains(mensagem)) {
			resposta.getMensagens().add(mensagem);
		}
		
		mensagem.setRespondida(true);
		
		mensagemRepository.save(mensagem);
		respostaRepository.save(resposta);
	}

}
