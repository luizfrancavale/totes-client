package io.testes.totvsclientapi.service;

import io.testes.totvsclientapi.entity.Client;
import io.testes.totvsclientapi.repository.ClientRepository;
import io.testes.totvsclientapi.service.impl.ClientServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientServiceImpl clientService;

    @Test
    public void validateClientAlreadyExists() {
        var name = "Lorem Ipsum";
        when(clientRepository.findByName(name)).thenReturn(List.of(new Client(UUID.randomUUID().toString(), name, "", "")));

        assertThatThrownBy(() -> clientService.validateExistingName(name))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("Client already exists");

        verify(clientRepository).findByName(name);
    }

    @Test
    public void validateClientDoesNotExist() {
        var name = "Lorem Ipsum";
        when(clientRepository.findByName(name)).thenReturn(new ArrayList<>());

        clientService.validateExistingName(name);

        verify(clientRepository).findByName(name);
    }

    @Test
    public void validatePhoneList() {
        List<String> phoneList = Arrays.asList("(61) 99932-6789", "(12) 98322-4567");

        ClientServiceImpl.validatePhoneFormat(phoneList);

        verify(clientRepository, never()).findByName(anyString());
    }

    @Test
    public void validateInvalidPhoneList() {
        List<String> phoneList = Arrays.asList("(12) 123456789", "(12) 123-45678", "12992345678");

        assertThatThrownBy(() -> ClientServiceImpl.validatePhoneFormat(phoneList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("One or more phone numbers do not have the correct format.");

        verify(clientRepository, never()).findByName(anyString());
    }

    @Test
    public void validateMixedPhoneList() {
        List<String> phoneList = Arrays.asList("(61) 99932-6789", "(12) 123-45678");

        assertThatThrownBy(() -> ClientServiceImpl.validatePhoneFormat(phoneList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("One or more phone numbers do not have the correct format.");

        verify(clientRepository, never()).findByName(anyString());
    }
}
