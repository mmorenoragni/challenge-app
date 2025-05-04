package com.example.challenge_app.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EmailSenderEventListener implements ApplicationListener<EmailSenderEvent> {
    private static final Logger logger = LoggerFactory.getLogger(EmailSenderEventListener.class);

    @Override
    public void onApplicationEvent(EmailSenderEvent event) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        logger.info("Sending email event {}", event.getMessage());
    }
}
