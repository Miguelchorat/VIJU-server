package com.example.vijuserver.users.controller;

import com.example.vijuserver.error.UserNotFoundException;
import com.example.vijuserver.security.jwt.JwtProvider;
import com.example.vijuserver.service.FavoriteService;
import com.example.vijuserver.service.LikeService;
import com.example.vijuserver.service.ReviewService;
import com.example.vijuserver.users.dto.*;
import com.example.vijuserver.users.model.UserEntity;
import com.example.vijuserver.users.services.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

/**
 * Controlador de usuario
 */
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserEntityService userService;
    private final UserDtoConverter userDtoConverter;
    private final LikeService likeService;
    private final FavoriteService favoriteService;
    private final ReviewService reviewService;
    private final JwtProvider tokenProvider;

    /**
     * Hace un listado de todo los usuarios
     * @return
     */
    @GetMapping("/users")
    public ResponseEntity<List<UserEntity>> findAll(){
        List<UserEntity> users = userService.findAll();
        if(users.isEmpty()){
            throw new UserNotFoundException();
        }
        return ResponseEntity.ok(users);
    }

    /**
     * Busca un usuario por su id
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    public ResponseEntity<UserEntity> findById(@PathVariable Long id) {
        UserEntity user = userService.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return ResponseEntity.ok(user);
    }

    /**
     * Busca un usuario por su nombre de usuario
     * @param username
     * @return
     */
    @GetMapping("/user/username={username}")
    public ResponseEntity<GetUserIdDto> findByUsername(@PathVariable String username) {
        UserEntity user = userService.findByUsername(username).orElseThrow(() -> new UserNotFoundException());
        GetUserIdDto getUserIdDto = userDtoConverter.convertUserEntityToGetUserIdDto(user);
        return ResponseEntity.ok(getUserIdDto);
    }

    /**
     * Recibe las estadistica de un usuario como su contador de likes, favoritos y de cuantas reviews tiene
     * @param username
     * @return
     */
    @GetMapping("/user/stats/username={username}")
    public ResponseEntity<UserStatsDto> getUserStats(@PathVariable String username) {
        UserEntity user = userService.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException());

        int likeCount = likeService.countLikesByUserId(user.getId());
        int favoriteCount = favoriteService.countFavoritesByUserId(user.getId());
        int reviewCount = reviewService.countReviewsByUserId(user.getId());

        UserStatsDto userStatsDto = new UserStatsDto(likeCount, favoriteCount, reviewCount);
        return ResponseEntity.ok(userStatsDto);
    }

    /**
     * Modifica un usuario
     * @param user
     * @param token
     * @return
     */
    @PutMapping("/user")
    public ResponseEntity<GetUserIdDto> update(@RequestBody CreateUserDto user, @RequestHeader("Authorization") String token) {
        Long userId = tokenProvider.getUserIdFromJWT(token);
        Optional<UserEntity> userCurrent = userService.findById(userId);
        if (userCurrent.isPresent()) {
            UserEntity userUpdated = userService.modifyUser(userCurrent.get(),user);
            GetUserIdDto getUserIdDto = userDtoConverter.convertUserEntityToGetUserIdDto(userUpdated);
            return new ResponseEntity<>(getUserIdDto, HttpStatus.OK);
        } else {
            throw new UserNotFoundException(userId);
        }
    }

    /**
     * Modifica el avatar de un usuario
     * @param user
     * @param token
     * @return
     */
    @PutMapping("/user/avatar")
    public ResponseEntity<GetUserIdDto> updateAvatar(@RequestBody UserEntity user, @RequestHeader("Authorization") String token) {
        Long userId = tokenProvider.getUserIdFromJWT(token);
        Optional<UserEntity> userCurrent = userService.findById(userId);
        if (userCurrent.isPresent()) {
            if(user.getAvatar().equalsIgnoreCase("1.svg") || user.getAvatar().equalsIgnoreCase("2.svg")
                    || user.getAvatar().equalsIgnoreCase("3.svg") || user.getAvatar().equalsIgnoreCase("4.svg")){
                userCurrent.get().setAvatar(user.getAvatar());
            } else {
                userCurrent.get().setAvatar("1.svg");
            }
            UserEntity userUpdated = userService.modify(userCurrent.get());
            GetUserIdDto getUserIdDto = userDtoConverter.convertUserEntityToGetUserIdDto(userUpdated);
            return ResponseEntity.ok(getUserIdDto);
        } else {
            throw new UserNotFoundException(userId);
        }
    }

    /**
     * Elimina un usuario
     * @param id
     * @return
     */
    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<UserEntity> user = userService.findById(id);
        if (user.isPresent()) {
            userService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            throw new UserNotFoundException(id);
        }
    }

    /**
     * Crea un nuevo usuario en el registro
     * @param newUser
     * @return
     */
    @PostMapping("/user")
    public ResponseEntity<GetUserDto> newUser(@RequestBody CreateUserDto newUser){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                userDtoConverter.convertUserEntityToGetUserDto(
                        userService.newUser(newUser)));
    }
}
