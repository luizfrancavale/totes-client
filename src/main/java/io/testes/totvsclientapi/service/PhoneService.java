package io.testes.totvsclientapi.service;

import io.testes.totvsclientapi.entity.Phone;

import java.util.List;

public interface PhoneService {
    List<Phone> findAllIn(List<String> phoneList);

    List<Phone> saveall(List<Phone> phones);

    List<Phone> getById(String uuid);
}
