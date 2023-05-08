package com.example.vijuserver.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FavoriteNotFoundException extends RuntimeException{
    public FavoriteNotFoundException(){
        super("No se puede encontrar ningun favorito");
    }

    public FavoriteNotFoundException(Long id){
        super("No se puede encontrar el favorito con la ID: " + id);
    }
}
