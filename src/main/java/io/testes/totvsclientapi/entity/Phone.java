package io.testes.totvsclientapi.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("phones")
public class Phone {

    @Id
    private ObjectId id;

    private String number;

    private String clientId;


    public Phone() {
        super();
    }

    public Phone(ObjectId id, String number, String clientId) {
        this.id = id;
        this.number = number;
        this.clientId = clientId;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
