package com.example.challenge_app.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class EmailSenderEventPublisher {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishEmailSenderEvent(final String message) {
        EmailSenderEvent emailSenderEvent = new EmailSenderEvent(this, message);
        applicationEventPublisher.publishEvent(emailSenderEvent);
    }
}
