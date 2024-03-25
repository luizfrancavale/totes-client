package io.testes.totvsclientapi.controller.dto;

public class ErrorDTO {

    private String message;
    private String userFriendlyMessage;

    public ErrorDTO() {
        super();
    }

    public ErrorDTO(String message, String userFriendlyMessage) {
        this.message = message;
        this.userFriendlyMessage = userFriendlyMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserFriendlyMessage() {
        return userFriendlyMessage;
    }

    public void setUserFriendlyMessage(String userFriendlyMessage) {
        this.userFriendlyMessage = userFriendlyMessage;
    }
}
