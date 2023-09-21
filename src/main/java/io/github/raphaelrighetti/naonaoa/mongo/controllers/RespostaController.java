package io.github.raphaelrighetti.naonaoa.mongo.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import io.github.raphaelrighetti.naonaoa.mongo.dto.RespostaAdicionarMensagemDTO;
import io.github.raphaelrighetti.naonaoa.mongo.dto.RespostaAtualizacaoDTO;
import io.github.raphaelrighetti.naonaoa.mongo.dto.RespostaCadastroDTO;
import io.github.raphaelrighetti.naonaoa.mongo.dto.RespostaLeituraDTO;
import io.github.raphaelrighetti.naonaoa.mongo.services.RespostaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/respostas")
public class RespostaController {

	@Autowired
	private RespostaService respostaService;
	
	@PostMapping
	public ResponseEntity<RespostaLeituraDTO> cadastrar(@RequestBody @Valid RespostaCadastroDTO dto,
			UriComponentsBuilder uriBuilder) {
		RespostaLeituraDTO responseDTO = respostaService.cadastrar(dto);
		URI uri = uriBuilder.path("/respostas/{id}").buildAndExpand(responseDTO.id()).toUri();
		
		return ResponseEntity.created(uri).body(responseDTO);
	}
	
	@GetMapping
	public ResponseEntity<Page<RespostaLeituraDTO>> listar(Pageable pageable) {
		Page<RespostaLeituraDTO> page = respostaService.listar(pageable);
		
		return ResponseEntity.ok(page);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RespostaLeituraDTO> obterPorId(@PathVariable String id) {
		RespostaLeituraDTO responseDTO = respostaService.obterDtoPorId(id);
		
		return ResponseEntity.ok(responseDTO);
	}
	
	@PutMapping("/{id}/adicionar-mensagem")
	public ResponseEntity<Void> adicionarMensagem(@PathVariable String id, 
			@RequestBody @Valid RespostaAdicionarMensagemDTO dto) {
		respostaService.adicionarMensagem(id, dto.mensagemId());
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable String id,
			@RequestBody @Valid RespostaAtualizacaoDTO dto) {
		respostaService.atualizar(id, dto);
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable String id) {
		respostaService.deletar(id);
		
		return ResponseEntity.noContent().build();
	}
	
	
}
