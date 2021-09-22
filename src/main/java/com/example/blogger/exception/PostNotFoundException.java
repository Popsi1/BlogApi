package com.example.blogger.exception;

import java.text.MessageFormat;

public class PostNotFoundException extends RuntimeException{
    public PostNotFoundException(final Long id){
        super(MessageFormat.format("Could not find cart with id: {0}", id));
    }
}
