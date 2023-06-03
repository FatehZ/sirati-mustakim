package com.ktxdevelopment.siratumustakim.exceptions;

import com.ktxdevelopment.siratumustakim.util.CustomResponseModel;
import com.ktxdevelopment.siratumustakim.util.RestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class MainExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<CustomResponseModel<String>> handleApiRequestException(Exception e) {
        return RestResponse.error(e.getLocalizedMessage());
    }
}