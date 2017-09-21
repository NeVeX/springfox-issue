package com.example.swagger.controllers.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Mark Cunningham on 9/21/2017.
 */
public class MessageDto {

    @JsonProperty("message")
    private String message = "default message";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
