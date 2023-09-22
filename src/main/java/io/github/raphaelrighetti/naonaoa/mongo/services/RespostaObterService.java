package io.github.raphaelrighetti.naonaoa.mongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.raphaelrighetti.naonaoa.exceptions.EntidadeNaoEncontradaException;
import io.github.raphaelrighetti.naonaoa.mongo.models.Resposta;
import io.github.raphaelrighetti.naonaoa.mongo.repositories.RespostaRepository;

@Service
public class RespostaObterService {
	
	@Autowired
	private RespostaRepository repository;
	
	public Resposta obterPorId(String id) {
		Resposta resposta = repository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Resposta"));
		
		return resposta;
	}
	
}
