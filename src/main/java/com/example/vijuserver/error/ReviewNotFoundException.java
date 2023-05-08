package com.example.vijuserver.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ReviewNotFoundException extends RuntimeException{
    public ReviewNotFoundException(){
        super("No se puede encontrar ninguna reseña");
    }

    public ReviewNotFoundException(Long id){
        super("No se puede encontrar la reseña con la ID: " + id);
    }
}
