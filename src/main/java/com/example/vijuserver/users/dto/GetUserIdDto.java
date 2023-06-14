package com.example.vijuserver.users.dto;

import lombok.*;

/**
 * Modelo de usuario con los datos mínimos mas su id
 */
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class GetUserIdDto {
    private Long id;
    private String username;
    private String avatar;
    private String email;
}
