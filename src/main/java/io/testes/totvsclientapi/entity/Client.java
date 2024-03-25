package io.testes.totvsclientapi.entity;

import io.testes.totvsclientapi.controller.dto.ClientCreateDTO;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document("clients")
public class Client {

    @Id
    private ObjectId id;
    private String uuid;

    private String name;
    private String address;
    private String neighborhood;


    public Client() {
        super();
    }

    public Client(ClientCreateDTO clientCreateDTO) {
        this.id = null;
        this.uuid = UUID.randomUUID().toString();
        this.name = clientCreateDTO.getName();
        this.address = clientCreateDTO.getAddress();
        this.neighborhood = clientCreateDTO.getNeighborhood();
    }

    public Client(String uuid, String name, String address, String neighborhood) {
        this.uuid = uuid;
        this.name = name;
        this.address = address;
        this.neighborhood = neighborhood;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
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
}
