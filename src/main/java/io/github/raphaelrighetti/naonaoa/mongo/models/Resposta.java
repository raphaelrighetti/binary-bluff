package io.github.raphaelrighetti.naonaoa.mongo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import io.github.raphaelrighetti.naonaoa.mongo.dto.RespostaAtualizacaoDTO;
import io.github.raphaelrighetti.naonaoa.mongo.dto.RespostaCadastroDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "respostas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resposta {

	@Id
	private String id;
	private String resposta;
	@DocumentReference(lazy = true)
	private Mensagem mensagem;
	private Long usuarioId;
	
	public Resposta(RespostaCadastroDTO dto) {
		resposta = dto.resposta();
		usuarioId = dto.usuarioId();
	}
	
	public void atualizar(RespostaAtualizacaoDTO dto) {
		resposta = dto.resposta();
	}
	
}
