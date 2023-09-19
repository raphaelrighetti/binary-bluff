package io.github.raphaelrighetti.naonaoa.mongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.github.raphaelrighetti.naonaoa.mongo.dto.RespostaAtualizacaoDTO;
import io.github.raphaelrighetti.naonaoa.mongo.dto.RespostaCadastroDTO;
import io.github.raphaelrighetti.naonaoa.mongo.dto.RespostaLeituraDTO;
import io.github.raphaelrighetti.naonaoa.mongo.models.Mensagem;
import io.github.raphaelrighetti.naonaoa.mongo.models.Resposta;
import io.github.raphaelrighetti.naonaoa.mongo.repositories.RespostaRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class RespostaService {
	
	@Autowired
	private RespostaRepository repository;
	
	@Autowired
	private MensagemService mensagemService;
	
	public RespostaLeituraDTO cadastrar(RespostaCadastroDTO dto) {
		Mensagem mensagem = mensagemService.obterPorId(dto.mensagemId());
		Resposta resposta = new Resposta(dto);
		resposta.setMensagem(mensagem);
		
		repository.save(resposta);
		
		return new RespostaLeituraDTO(resposta);
	}
	
	public Page<RespostaLeituraDTO> listar(Pageable pageable) {
		Page<RespostaLeituraDTO> page = 
				repository.findAll(pageable).map(resposta -> new RespostaLeituraDTO(resposta));
		
		return page;
	}
	
	public Resposta obterPorId(String id) {
		Resposta resposta = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException());
		
		return resposta;
	}
	
	public RespostaLeituraDTO obterDtoPorId(String id) {
		return new RespostaLeituraDTO(obterPorId(id));
	}
	
	public void atualizar(String id, RespostaAtualizacaoDTO dto) {
		Resposta resposta = obterPorId(id);
		resposta.atualizar(dto);
		
		repository.save(resposta);
	}
	
	public void deletar(String id) {
		Resposta resposta = obterPorId(id);
		
		repository.delete(resposta);
	}
	
}
