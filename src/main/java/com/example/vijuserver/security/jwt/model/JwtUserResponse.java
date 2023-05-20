package com.example.vijuserver.security.jwt.model;

import com.example.vijuserver.users.dto.GetUserDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JwtUserResponse extends GetUserDto {
    private String token;

    @Builder(builderMethodName="jwtUserResponseBuilder")
    public JwtUserResponse(String username, String avatar, String email, String token) {
        super(username, avatar, email);
        this.token = token;
    }
}
