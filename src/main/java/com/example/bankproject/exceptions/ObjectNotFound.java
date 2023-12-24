package com.example.bankproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ObjectNotFound extends RuntimeException{

    public ObjectNotFound(String message) {
        super(message);
    }
    //todo сделать через GlobalServerExceptionHandler самый идеальный вариант обработки всех исключений в одном классе
}
