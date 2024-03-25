package io.testes.totvsclientapi.controller;

import io.testes.totvsclientapi.controller.dto.PhoneDTO;
import io.testes.totvsclientapi.entity.Phone;
import io.testes.totvsclientapi.service.PhoneService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/phones")
public class PhoneController {

    private final PhoneService phoneService;

    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    /**
     * Endpoint for retrieving all phone numbers associated with a client specified by UUID.
     *
     * @param uuid The UUID of the client's phone numbers to be retrieved.
     * @return A ResponseEntity containing a list of phone numbers associated with the client.
     */
    @GetMapping("/{uuid}")
    private ResponseEntity<List<String>> getAllPhonesByClientId(
            @PathVariable String uuid
    ) {
        var phones = phoneService.getById(uuid).stream().map(Phone::getNumber).toList();
        return ResponseEntity.ok().body(phones);
    }

}
