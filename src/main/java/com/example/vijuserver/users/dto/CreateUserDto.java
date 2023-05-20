package com.example.vijuserver.users.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class CreateUserDto {
    private String username;
    private String email;
    private String avatar;
    private String password;
    private String password2;
}
