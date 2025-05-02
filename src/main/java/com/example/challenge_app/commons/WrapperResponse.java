package com.example.challenge_app.commons;

public class WrapperResponse<E> {

    private E apiResponse;

    public E getApiResponse() {
        return apiResponse;
    }

    public void setApiResponse(E apiResponse) {
        this.apiResponse = apiResponse;
    }
}
