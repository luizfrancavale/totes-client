package io.testes.totvsclientapi.repository;

import io.testes.totvsclientapi.entity.Client;
import io.testes.totvsclientapi.entity.Phone;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneRepository extends MongoRepository<Phone, ObjectId> {
    List<Phone> findByNumberIn(List<String> phoneList);

    List<Phone> findByClientId(String uuid);
}
