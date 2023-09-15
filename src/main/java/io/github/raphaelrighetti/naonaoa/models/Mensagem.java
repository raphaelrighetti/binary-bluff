package io.github.raphaelrighetti.naonaoa.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import io.github.raphaelrighetti.naonaoa.dto.MensagemCadastroDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "mensagens")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mensagem {
	
	@Id
	private String id;
	@NotBlank
	@Size(min = 3)
	private String mensagem;
	@DocumentReference
	private List<Resposta> respostas;
	
	public Mensagem(MensagemCadastroDTO dto) {
		mensagem = dto.mensagem();
	}

}
