package com.example.bankproject.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler  //аннотация для метода перехватывающего исключения
    public ResponseEntity<String> handlerException (ObjectNotFound objectNotFound)
    {
       //логи?

        return new ResponseEntity<>(objectNotFound.getMessage(),HttpStatus.NOT_FOUND);
    }
}
