package com.example.vijuserver.security.jwt.model;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor
@AllArgsConstructor
/**
 * Campos necesarios para el login del usuario
 */
public class LoginRequest {

    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
