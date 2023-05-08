package com.example.vijuserver.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){
        super("No se puede encontrar ningun usuario");
    }

    public UserNotFoundException(Long id){
        super("No se puede encontrar el usuario con la ID: " + id);
    }
}
