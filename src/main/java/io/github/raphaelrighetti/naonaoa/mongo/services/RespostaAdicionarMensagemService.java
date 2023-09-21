package io.github.raphaelrighetti.naonaoa.mongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.raphaelrighetti.naonaoa.mongo.models.Mensagem;
import io.github.raphaelrighetti.naonaoa.mongo.models.Resposta;
import io.github.raphaelrighetti.naonaoa.mongo.repositories.RespostaRepository;

@Service
public class RespostaAdicionarMensagemService {

	@Autowired
	private RespostaRepository repository;
	
	public void adicionarMensagem(Resposta resposta, Mensagem mensagem) {
		if (resposta.getMensagens().isEmpty()) {
			resposta.setMensagens(List.of(mensagem));
		} else {
			resposta.getMensagens().add(mensagem);
		}
		
		repository.save(resposta);
	}
	
}
