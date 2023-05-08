package com.example.vijuserver.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LikeNotFoundException extends RuntimeException{
    public LikeNotFoundException(){
        super("No se puede encontrar ningun me gusta");
    }

    public LikeNotFoundException(Long id){
        super("No se puede encontrar el me gusta con la ID: " + id);
    }
}
