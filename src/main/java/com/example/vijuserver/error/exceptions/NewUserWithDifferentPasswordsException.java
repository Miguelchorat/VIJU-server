package com.example.vijuserver.error.exceptions;

/**
 * Error de la creación de usuario las contraseñas no coinciden
 */
public class NewUserWithDifferentPasswordsException extends RuntimeException{
    private static final long serialVersionUID = -7978601526802035152L;

    public NewUserWithDifferentPasswordsException() {
        super("Las contraseñas no coinciden");
    }
}
