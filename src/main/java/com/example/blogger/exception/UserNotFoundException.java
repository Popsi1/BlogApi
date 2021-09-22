package com.example.blogger.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.MessageFormat;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(final Long id){
        super(MessageFormat.format("Could not find cart with id: {0}", id));
    }








}
