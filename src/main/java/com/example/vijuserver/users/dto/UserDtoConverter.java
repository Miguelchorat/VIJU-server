package com.example.vijuserver.users.dto;

import com.example.vijuserver.users.model.UserEntity;
import org.springframework.stereotype.Component;

/**
 * Clase que se encarga de automatizar el cambio del UserEntity a un DTO en concreto
 */
@Component
public class UserDtoConverter {
    public GetUserDto convertUserEntityToGetUserDto(UserEntity user) {
        return GetUserDto.builder()
                .username(user.getUsername())
                .avatar(user.getAvatar())
                .email(user.getEmail())
                .build();
    }

    public GetUserIdDto convertUserEntityToGetUserIdDto(UserEntity user) {
        return GetUserIdDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .avatar(user.getAvatar())
                .email(user.getEmail())
                .build();
    }

}
