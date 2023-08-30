package com.ktxdevelopment.siratumustakim;

import com.ktxdevelopment.siratumustakim.exceptions.*;
import com.ktxdevelopment.siratumustakim.util.response.CustomResponseModel;
import com.ktxdevelopment.siratumustakim.util.response.RestResponse;
import jakarta.ws.rs.ext.Provider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Provider
@ControllerAdvice
public class MainExceptionHandler {

    @ExceptionHandler(value = {CategoryNotFoundException.class})
    public ResponseEntity<CustomResponseModel<String>> handleNotFoundException(Throwable e) {
        return RestResponse.error(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {UserExistsException.class})
    public ResponseEntity<CustomResponseModel<String>> handleUserExistsException(Throwable e) {
        return RestResponse.error(e, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<CustomResponseModel<String>> handleUserNotFoundException(Throwable e) {
        return RestResponse.error(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = UsernameNotFoundException.class)
    public ResponseEntity<CustomResponseModel<String>> handleUsernameNotFoundException(Throwable e) {
        return RestResponse.error(e, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(value = PostNotFoundException.class)
    public ResponseEntity<CustomResponseModel<String>> handlePostNotFoundException(Throwable e) {
        return RestResponse.error(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = AuthRequestNotCorrectException.class)
    public ResponseEntity<CustomResponseModel<String>> handleWrongRequestException(Throwable e) {
        return RestResponse.error(e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = ApiKeyInvalidException.class)
    public ResponseEntity<CustomResponseModel<String>> handleInvalidAPiKeyException(Throwable e) {
        return RestResponse.error(e, HttpStatus.UNAUTHORIZED);
    }
}