package com.vasactrl.exceptions.handlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;

import javax.security.auth.login.AccountNotFoundException;

@RestControllerAdvice
public class AccountExceptionHandler {
    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<String> handleAccountNotFoundException(AccountNotFoundException ex){
        return ResponseEntity.status(404).body(ex.getMessage());
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<String> handleDuplicateKeyException(DuplicateKeyException ex){
        return ResponseEntity.status(404).body(ex.getMessage());
    }


}
