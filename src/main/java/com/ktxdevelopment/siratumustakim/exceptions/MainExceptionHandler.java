package com.ktxdevelopment.siratumustakim.exceptions;

import com.ktxdevelopment.siratumustakim.util.response.CustomResponseModel;
import com.ktxdevelopment.siratumustakim.util.response.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class MainExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<CustomResponseModel<String>> handleAllExceptions(Exception e) {
        return RestResponse.error(e);
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<CustomResponseModel<String>> handleUserNotFoundException(Exception e) {
        return RestResponse.error(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = UsernameNotFoundException.class)
    public ResponseEntity<CustomResponseModel<String>> handleUsernameNotFoundException(Exception e) {
        return RestResponse.error(e, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(value = PostNotFoundException.class)
    public ResponseEntity<CustomResponseModel<String>> handlePostNotFoundException(Exception e) {
        return RestResponse.error(e, HttpStatus.NOT_FOUND);
    }
}