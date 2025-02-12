package io.testes.totvsclientapi.repository;

import io.testes.totvsclientapi.entity.Client;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends MongoRepository<Client, ObjectId> {

    List<Client> findByName(String name);

}
