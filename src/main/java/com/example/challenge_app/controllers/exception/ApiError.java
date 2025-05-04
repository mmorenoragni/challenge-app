package com.example.challenge_app.controllers.exception;

import org.springframework.http.HttpStatus;

import java.util.List;

public class ApiError {

    private final HttpStatus status;
    private final String message;
    private final List<String> errors;

    public ApiError(HttpStatus status, String message, List<String> errors) {
        this.status = status;
        this.message = message;
        this.errors = errors;
    }
}
