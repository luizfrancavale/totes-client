package io.testes.totvsclientapi.controller;

import io.testes.totvsclientapi.controller.dto.PhoneDTO;
import io.testes.totvsclientapi.entity.Client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClientDTO {
    private String uuid;

    private String name;
    private String address;
    private String neighborhood;

    private List<String> phoneList;

    public ClientDTO() {
        super();
    }

    public ClientDTO(Client client) {
        this.uuid = client.getUuid();
        this.name = client.getName();
        this.address = client.getAddress();
        this.neighborhood = client.getNeighborhood();
        this.phoneList = Collections.emptyList();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public List<String> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<String> phoneList) {
        this.phoneList = phoneList;
    }
}
