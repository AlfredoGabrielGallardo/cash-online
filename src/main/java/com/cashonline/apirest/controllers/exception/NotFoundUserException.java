package com.cashonline.apirest.controllers.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//File to make exception (search user by id):
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundUserException extends RuntimeException {

    public NotFoundUserException(String message){
        super(message);
    }
}
