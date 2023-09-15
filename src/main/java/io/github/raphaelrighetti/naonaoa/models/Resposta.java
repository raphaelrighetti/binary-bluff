package io.github.raphaelrighetti.naonaoa.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

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
	
}
