package io.testes.totvsclientapi.controller.dto;


import java.util.List;

public class ClientCreateDTO {

    private String name;

    private String address;

    private String neighborhood;

    private List<String> phoneList;

    public ClientCreateDTO() {
        super();
    }

    public ClientCreateDTO(String name, String address, String neighborhood, List<String> phoneList) {
        this.name = name;
        this.address = address;
        this.neighborhood = neighborhood;
        this.phoneList = phoneList;
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
