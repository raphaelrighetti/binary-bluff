package io.github.raphaelrighetti.naonaoa.mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.github.raphaelrighetti.naonaoa.mongo.models.Mensagem;

public interface MensagemRepository extends MongoRepository<Mensagem, String> {

}
