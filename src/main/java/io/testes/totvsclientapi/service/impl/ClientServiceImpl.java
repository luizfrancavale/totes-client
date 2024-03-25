package io.testes.totvsclientapi.service.impl;

import io.testes.totvsclientapi.controller.dto.ClientCreateDTO;
import io.testes.totvsclientapi.entity.Client;
import io.testes.totvsclientapi.entity.Phone;
import io.testes.totvsclientapi.repository.ClientRepository;
import io.testes.totvsclientapi.service.ClientService;
import io.testes.totvsclientapi.service.PhoneService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class ClientServiceImpl implements ClientService {

    private final PhoneService phoneService;

    private final ClientRepository clientRepository;

    public ClientServiceImpl(PhoneService phoneService, ClientRepository clientRepository) {
        this.phoneService = phoneService;
        this.clientRepository = clientRepository;
    }

    private void validateExistingPhone(List<String> phoneList) {
        if (!this.phoneService.findAllIn(phoneList).isEmpty()) {
            throw new IllegalStateException("Phone already taken");
        }
    }

    @Override
    public List<Client> findAll(Integer page, Integer pageSize) {
        return clientRepository.findAll();
    }

    private void validateForm(ClientCreateDTO clientCreateDTO) {
        validatePhoneFormat(clientCreateDTO.getPhoneList());
        validateExistingPhone(clientCreateDTO.getPhoneList());
        validateExistingName(clientCreateDTO.getName());
    }

    private void savePhoneList(ClientCreateDTO clientCreateDTO, Client client) {
        var phoneList = clientCreateDTO.getPhoneList().stream()
                .map(phone -> new Phone(null, phone, client.getUuid()))
                .toList();
        phoneService.saveall(phoneList);
    }

    @Override
    public Client save(ClientCreateDTO clientCreateDTO) {
        validateForm(clientCreateDTO);

        var client = clientRepository.save(new Client(clientCreateDTO));
        savePhoneList(clientCreateDTO, client);

        return client;
    }

    public void validateExistingName(String name) {
        if (!clientRepository.findByName(name).isEmpty()) {
            throw new IllegalStateException("Client already exists");
        }

    }

    public static void validatePhoneFormat(List<String> phoneList) {
        var pattern = Pattern.compile("^\\(\\d{2}\\)\\s\\d{5}-\\d{4}$");

        if (phoneList.stream()
                .anyMatch(phone -> !pattern.matcher(phone).matches())) {
            throw new IllegalArgumentException("One or more phone numbers do not have the correct format.");
        }
    }
}
