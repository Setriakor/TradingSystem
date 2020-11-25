package com.tradingsys.demo.client.exception;


//custom user not found exception.
public class UserNotFoundException extends  RuntimeException {
    public UserNotFoundException(Long id) {
        super("User with id : " + id + " not found." );
    }
}
