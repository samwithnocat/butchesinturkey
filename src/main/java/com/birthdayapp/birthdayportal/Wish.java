package com.birthdayapp.birthdayportal;

import jakarta.persistence.*;

@Entity
public class Wish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    public String sender;

    public Wish() {}

    public Wish(Long id, String message, String sender) {
        this.id = id;
        this.message = message;
        this.sender = sender;

    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



}
