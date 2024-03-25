package io.testes.totvsclientapi.service.impl;

import io.testes.totvsclientapi.entity.Phone;
import io.testes.totvsclientapi.repository.PhoneRepository;
import io.testes.totvsclientapi.service.PhoneService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneServiceImpl implements PhoneService {

    private final PhoneRepository phoneRepository;

    public PhoneServiceImpl(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    @Override
    public List<Phone> findAllIn(List<String> phoneList) {
        return phoneRepository.findByNumberIn(phoneList);
    }

    @Override
    public List<Phone> saveall(List<Phone> phones) {
        return phoneRepository.saveAll(phones);
    }

    @Override
    public List<Phone> getById(String uuid) {
        return phoneRepository.findByClientId(uuid);
    }
}
