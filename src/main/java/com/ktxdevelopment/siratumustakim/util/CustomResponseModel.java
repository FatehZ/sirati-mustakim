package com.ktxdevelopment.siratumustakim.util;

import jakarta.annotation.Nullable;
import org.springframework.http.HttpStatus;

public class CustomResponseModel<T> {  //todo can add timestamp to response
    private final HttpStatus status;
    private final T data;
    private final RestError error;

    public CustomResponseModel(T data, HttpStatus status) {
        this.status = status;
        this.data = data;
        this.error = null;
    }

    public CustomResponseModel(RestError error, HttpStatus status) {
        this.status = status;
        this.error = error;
        this.data = null;
    }

    public CustomResponseModel(Exception ex, HttpStatus status) {
        this.status = status;
        this.error = new RestError(ex.getClass().toString(), ex.getLocalizedMessage());
        this.data = null;
    }

    public CustomResponseModel(String errorTitle, String errorMessage, HttpStatus status) {
        this.status = status;
        this.error = new RestError(errorTitle,errorMessage);
        this.data = null;
    }

    public CustomResponseModel(T data) {
        this.data = data;
        this.error = null;
        this.status = HttpStatus.OK;
    }

    public CustomResponseModel(RestError error) {
        this.error = error;
        this.data = null;
        this.status = HttpStatus.BAD_REQUEST;
    }
}
