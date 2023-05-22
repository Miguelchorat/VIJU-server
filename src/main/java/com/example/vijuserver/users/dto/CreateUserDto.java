package com.example.vijuserver.users.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Pattern;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class CreateUserDto {

    @Pattern(regexp = "/^[a-zA-Z\\d]{3,18}$/", message = "Nombre de usuario no válido")
    private String username;

    @Pattern(regexp = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$", message = "Correo electrónico no válido")
    private String email;

    private String avatar;

    @Pattern(regexp = "/^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,32}$/", message = "Contraseña no válida")
    private String password;

    private String password2;
}
