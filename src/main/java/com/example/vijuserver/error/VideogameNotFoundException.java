package com.example.vijuserver.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class VideogameNotFoundException extends RuntimeException{
    public VideogameNotFoundException(){
        super("No se puede encontrar ningun videojuego");
    }

    public VideogameNotFoundException(Long id){
        super("No se puede encontrar el videojuego con la ID: " + id);
    }
}
