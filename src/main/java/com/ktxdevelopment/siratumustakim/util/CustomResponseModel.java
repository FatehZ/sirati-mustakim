package com.ktxdevelopment.siratumustakim.util;

import org.springframework.http.HttpStatus;

public class CustomResponseModel<T> {  //todo can add timestamp to response
    HttpStatus status;
    T data;
    String error;

    public CustomResponseModel(T data, HttpStatus status) {
        this.status = status;
        this.data = data;
        this.error = null;
    }

    public CustomResponseModel(String error, HttpStatus status) {
        this.status = status;
        this.error = error;
        this.data = null;
    }

    public CustomResponseModel(T data) {
        this.data = data;
        this.error = null;
        this.status = HttpStatus.OK;
    }

    public CustomResponseModel(String error) {
        this.error = error;
        this.data = null;
        this.error = error;
        this.status = HttpStatus.OK;
    }
}
