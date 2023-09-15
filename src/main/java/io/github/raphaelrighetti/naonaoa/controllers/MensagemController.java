package io.github.raphaelrighetti.naonaoa.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import io.github.raphaelrighetti.naonaoa.dto.MensagemCadastroDTO;
import io.github.raphaelrighetti.naonaoa.dto.MensagemLeituraDTO;
import io.github.raphaelrighetti.naonaoa.services.MensagemService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/mensagens")
public class MensagemController {

	@Autowired
	private MensagemService service;
	
	@PostMapping
	public ResponseEntity<MensagemLeituraDTO> cadastrar(@RequestBody @Valid MensagemCadastroDTO dto,
			UriComponentsBuilder uriBuilder) {
		MensagemLeituraDTO responseDTO = service.cadastrar(dto);
		URI uri = uriBuilder.path("/mensagens/{id}").buildAndExpand(responseDTO.id()).toUri();
		
		return ResponseEntity.created(uri).body(responseDTO);
	}
	
	@GetMapping
	public ResponseEntity<Page<MensagemLeituraDTO>> listar(Pageable pageable) {
		Page<MensagemLeituraDTO> page = service.listar(pageable);
		
		return ResponseEntity.ok(page);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MensagemLeituraDTO> obterPorId(@PathVariable String id) {
		MensagemLeituraDTO responseDTO = service.obterDtoPorId(id);
		
		return ResponseEntity.ok(responseDTO);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable String id) {
		service.deletar(id);
		
		return ResponseEntity.noContent().build();
	}
	
	
}
