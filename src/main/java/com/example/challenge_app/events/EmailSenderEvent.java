package com.example.challenge_app.events;

import org.springframework.context.ApplicationEvent;

public class EmailSenderEvent extends ApplicationEvent {
    private String message;

    public EmailSenderEvent(Object source, String message) {
        super(source);
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
