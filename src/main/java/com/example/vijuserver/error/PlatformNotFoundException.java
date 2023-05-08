package com.example.vijuserver.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PlatformNotFoundException extends RuntimeException{
    public PlatformNotFoundException(){
        super("No se puede encontrar ningun plataforma");
    }

    public PlatformNotFoundException(Long id){
        super("No se puede encontrar la plataforma con la ID: " + id);
    }
}
