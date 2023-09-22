package io.github.raphaelrighetti.naonaoa.mongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.raphaelrighetti.naonaoa.exceptions.EntidadeNaoEncontradaException;
import io.github.raphaelrighetti.naonaoa.mongo.models.Mensagem;
import io.github.raphaelrighetti.naonaoa.mongo.repositories.MensagemRepository;

@Service
public class MensagemObterService {
	
	@Autowired
	private MensagemRepository repository;
	
	public Mensagem obterPorId(String id) {
		Mensagem mensagem = repository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Mensagem"));
		
		return mensagem;
	}
	
	public Mensagem obterPorMensagem(String mensagemConteudo) {
		Mensagem mensagem = repository.findByMensagem(mensagemConteudo);
		
		if (mensagem == null) {
			throw new EntidadeNaoEncontradaException("Mensagem");
		}
		
		return mensagem;
	}

}
