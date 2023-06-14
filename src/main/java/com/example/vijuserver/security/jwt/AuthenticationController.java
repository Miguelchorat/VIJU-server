package com.example.vijuserver.security.jwt;

import com.example.vijuserver.security.jwt.model.JwtUserResponse;
import com.example.vijuserver.security.jwt.model.LoginRequest;
import com.example.vijuserver.users.dto.GetUserDto;
import com.example.vijuserver.users.dto.UserDtoConverter;
import com.example.vijuserver.users.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

/**
 * Controlador de autenticación en la aplicación
 */
@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final JwtProvider tokenProvider;
    private final UserDtoConverter converter;

    /**
     * Login del usuario y sus comprobaciones necesarias. Devuelve el token de auth en la petición
     * @param loginRequest
     * @return
     */
    @PostMapping("/auth/login")
    public JwtUserResponse login(@Valid @RequestBody LoginRequest loginRequest) {
        if (!loginRequest.getUsername().matches("^[a-zA-Z\\d]{3,18}$")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nombre de usuario no válido");
        }
        if (!loginRequest.getPassword().matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,32}$")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Contraseña no válida");
        }
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                loginRequest.getUsername(),
                                loginRequest.getPassword()
                        )
                );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserEntity user = (UserEntity) authentication.getPrincipal();
        String jwtToken = tokenProvider.generateToken(authentication);

        return convertUserEntityAndTokenToJwtUserResponse(user, jwtToken);

    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/user/me")
    public GetUserDto me(@AuthenticationPrincipal UserEntity user) {
        return converter.convertUserEntityToGetUserDto(user);
    }



    private JwtUserResponse convertUserEntityAndTokenToJwtUserResponse(UserEntity user, String jwtToken) {
        return JwtUserResponse
                .jwtUserResponseBuilder()
                .email(user.getEmail())
                .username(user.getUsername())
                .avatar(user.getAvatar())
                .token(jwtToken)
                .build();

    }
}
