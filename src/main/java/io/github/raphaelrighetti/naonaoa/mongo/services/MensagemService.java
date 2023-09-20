package io.github.raphaelrighetti.naonaoa.mongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.github.raphaelrighetti.naonaoa.mongo.dto.MensagemCadastroDTO;
import io.github.raphaelrighetti.naonaoa.mongo.dto.MensagemLeituraDTO;
import io.github.raphaelrighetti.naonaoa.mongo.models.Mensagem;
import io.github.raphaelrighetti.naonaoa.mongo.models.Resposta;
import io.github.raphaelrighetti.naonaoa.mongo.repositories.MensagemRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class MensagemService {
	
	@Autowired
	private MensagemRepository repository;
	
	public MensagemLeituraDTO cadastrar(MensagemCadastroDTO dto) {
		Mensagem mensagem = new Mensagem(dto);
		repository.save(mensagem);
		
		return new MensagemLeituraDTO(mensagem);
	}
	
	public Page<MensagemLeituraDTO> listar(Pageable pageable) {
		Page<MensagemLeituraDTO> page = 
				repository.findAll(pageable).map(MensagemLeituraDTO::new);
		
		return page;
	}
	
	public Mensagem obterPorId(String id) {
		Mensagem mensagem = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException());
		
		return mensagem;
	}
	
	public MensagemLeituraDTO obterDtoPorId(String id) {
		return new MensagemLeituraDTO(obterPorId(id));
	}
	
	public void adicionarResposta(Mensagem mensagem, Resposta resposta) {
		mensagem.getRespostas().add(resposta);
		mensagem.setRespondida(true);
		
		repository.save(mensagem);
	}
	
	public void deletar(String id) {
		Mensagem mensagem = obterPorId(id);
		
		repository.delete(mensagem);
	}
	
}
