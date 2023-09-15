package io.github.raphaelrighetti.naonaoa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.github.raphaelrighetti.naonaoa.dto.MensagemCadastroDTO;
import io.github.raphaelrighetti.naonaoa.dto.MensagemLeituraDTO;
import io.github.raphaelrighetti.naonaoa.models.Mensagem;
import io.github.raphaelrighetti.naonaoa.repositories.MensagemRepository;
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
		Page<MensagemLeituraDTO> page = repository.findAll(pageable)
				.map(msg -> new MensagemLeituraDTO(msg));
		
		return page;
	}
	
	public Mensagem obterPorId(String id) {
		Mensagem mensagem = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException());
		
		return mensagem;
	}
	
	public MensagemLeituraDTO obterDtoPorId(String id) {
		Mensagem mensagem = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException());
		
		return new MensagemLeituraDTO(mensagem);
	}
	
	public void deletar(String id) {
		Mensagem mensagem = obterPorId(id);
		
		repository.delete(mensagem);
	}
	
}
