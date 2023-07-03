package com.ktxdevelopment.siratumustakim;

import com.ktxdevelopment.siratumustakim.exceptions.AuthRequestNotCorrectException;
import com.ktxdevelopment.siratumustakim.exceptions.PostNotFoundException;
import com.ktxdevelopment.siratumustakim.exceptions.UserExistsException;
import com.ktxdevelopment.siratumustakim.exceptions.UserNotFoundException;
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

//    @ExceptionHandler(value = {Throwable.class})
//    public ResponseEntity<CustomResponseModel<String>> handleAllExceptions(Exception e) {
//        return RestResponse.error(e, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @ExceptionHandler(value = {UserExistsException.class})
    public ResponseEntity<CustomResponseModel<String>> handleUserExistsException(Exception e) {
        return RestResponse.error(e, HttpStatus.CONFLICT);
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

    @ExceptionHandler(value = AuthRequestNotCorrectException.class)
    public ResponseEntity<CustomResponseModel<String>> handleWrongRequestException(Exception e) {
        return RestResponse.error(e, HttpStatus.BAD_REQUEST);
    }
}