package com.ktxdevelopment.siratumustakim.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RestResponse {

    public static <T> ResponseEntity<CustomResponseModel<T>> ok(T body) {
        return ResponseEntity.ok(new CustomResponseModel<>(body));
    }


    public static ResponseEntity<CustomResponseModel<String>> error(RestError error) {
        return new ResponseEntity<>(new CustomResponseModel<>(error), HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<CustomResponseModel<String>> error(Exception e, HttpStatus status) {
        return new ResponseEntity<>(new CustomResponseModel<>(e, status), status);
    }

    public static ResponseEntity<CustomResponseModel<String>> error(Exception e) {
        return new ResponseEntity<>(new CustomResponseModel<>(e, HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }
}
