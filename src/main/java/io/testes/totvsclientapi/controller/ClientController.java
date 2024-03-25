package io.testes.totvsclientapi.controller;

import io.testes.totvsclientapi.controller.dto.ClientCreateDTO;
import io.testes.totvsclientapi.entity.Client;
import io.testes.totvsclientapi.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    /**
     * Endpoint for retrieving a paginated list of all clients.
     *
     * @param page     The page number for pagination. Defaults to 0 if not provided.
     *                 This parameter determines the page from frontend's cursor.
     * @param pageSize The size of each page for pagination. Defaults to 25 if not provided.
     * @return A ResponseEntity containing a paginated list of client DTOs.
     *         The list may be empty if no clients are found based on the provided criteria.
     * @apiNote This endpoint supports pagination but it's optional and fault-tolerant
     */
    @GetMapping
    public ResponseEntity<List<ClientDTO>> getAllClients(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "25") Integer pageSize
    ) {
        return ResponseEntity.ok().body(
                clientService.findAll(page, pageSize)
                        .stream()
                        .map(ClientDTO::new)
                        .toList()
        );
    }

    /**
     * Endpoint for creating a new client.
     *
     * @param clientCreateDTO The DTO containing the data for creating a new client.
     *                        PhoneList must comply to format '(99) 99999-9999'.
     * @return A ResponseEntity containing the newly created client resource.
     * @throws Exception If there is an unexpected error during the client creation process.
     *                   This may include:
     *                   Form Validation errors like badly formatted phoneList.
     *                   Existing client with the same name.
     *                   Name too short or too long.
     */
    @PostMapping
    public ResponseEntity<Client> createClient(
            @RequestBody ClientCreateDTO clientCreateDTO
    ) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(clientCreateDTO));
    }

}
