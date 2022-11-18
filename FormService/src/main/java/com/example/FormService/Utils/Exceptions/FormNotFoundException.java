package com.example.FormService.Utils.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FormNotFoundException extends RuntimeException{
    public FormNotFoundException(String message){
        super(message);
    }
}
