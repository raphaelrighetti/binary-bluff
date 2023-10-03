package io.github.raphaelrighetti.naonaoa.mongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.github.raphaelrighetti.naonaoa.exceptions.ArgumentoInvalidoException;
import io.github.raphaelrighetti.naonaoa.exceptions.MensagemNaoEncontradaException;
import io.github.raphaelrighetti.naonaoa.mongo.dto.MensagemCadastroDTO;
import io.github.raphaelrighetti.naonaoa.mongo.dto.MensagemLeituraDTO;
import io.github.raphaelrighetti.naonaoa.mongo.models.Mensagem;
import io.github.raphaelrighetti.naonaoa.mongo.repositories.MensagemRepository;

@Service
public class MensagemService {
	
	@Autowired
	private MensagemRepository repository;
	
	@Autowired
	private MensagemObterService mensagemObterService;
	
	@Autowired
	private AdicionarRespostaService adicionarRespostaService;
	
	public MensagemLeituraDTO cadastrar(MensagemCadastroDTO dto) {
		try {
			Mensagem cadastrada = mensagemObterService.obterPorMensagem(dto.mensagem());
			
			return new MensagemLeituraDTO(cadastrada);
		} catch (MensagemNaoEncontradaException ex) {
		}
		
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
		return mensagemObterService.obterPorId(id);
	}
	
	public MensagemLeituraDTO obterDtoPorId(String id) {
		return new MensagemLeituraDTO(obterPorId(id));
	}
	
	public Mensagem obterPorMensagem(String mensagem) {
		return mensagemObterService.obterPorMensagem(mensagem);
	}
	
	public MensagemLeituraDTO obterDtoPorMensagem(String mensagem) {
		return new MensagemLeituraDTO(obterPorMensagem(mensagem));
	}
	
	public void adicionarResposta(String mensagemId, String respostaId) {
		if (mensagemId.equals(respostaId)) {
			throw new ArgumentoInvalidoException("Uma mensagem não pode ser resposta dela mesma!");
		}
		
		Mensagem mensagem = mensagemObterService.obterPorId(mensagemId);
		Mensagem resposta = mensagemObterService.obterPorId(respostaId);
		
		adicionarRespostaService.adicionarResposta(mensagem, resposta);
	}
	
	public void deletar(String id) {
		Mensagem mensagem = obterPorId(id);
		
		repository.delete(mensagem);
	}
	
}
