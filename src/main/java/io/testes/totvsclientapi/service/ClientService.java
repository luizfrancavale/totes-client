package io.testes.totvsclientapi.service;

import io.testes.totvsclientapi.controller.dto.ClientCreateDTO;
import io.testes.totvsclientapi.entity.Client;

import java.util.List;

public interface ClientService {
    List<Client> findAll(Integer page, Integer pageSize);

    Client save(ClientCreateDTO client) throws Exception;
}
