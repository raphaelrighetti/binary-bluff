package io.github.raphaelrighetti.naonaoa.mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.github.raphaelrighetti.naonaoa.mongo.models.Resposta;

public interface RespostaRepository extends MongoRepository<Resposta, String> {

}
