package com.cashonline.apirest.controllers.exception;

//File to make exception (search user by id):
public class ExceptionResponse {

    private String message;

    public ExceptionResponse(String message){
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
