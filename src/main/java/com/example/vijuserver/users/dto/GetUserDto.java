package com.example.vijuserver.users.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Modelo usado para mostrar los datos mínimos de usuario
 */
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class GetUserDto {
    private String username;
    private String avatar;
    private String email;
}
