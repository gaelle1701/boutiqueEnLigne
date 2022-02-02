package com.boutiqueEnLigne.fngcine.payload.response;

import lombok.Data;
import lombok.Getter;

@Data
public class MessageResponse {
    private String message;

    public MessageResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
