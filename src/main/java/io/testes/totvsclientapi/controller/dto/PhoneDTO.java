package io.testes.totvsclientapi.controller.dto;

public class PhoneDTO {

    private String phoneNumber;

    public PhoneDTO() {
        super();
    }

    public PhoneDTO(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
