package io.github.raphaelrighetti.naonaoa.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.github.raphaelrighetti.naonaoa.models.Mensagem;

public interface MensagemRepository extends MongoRepository<Mensagem, String> {

}
