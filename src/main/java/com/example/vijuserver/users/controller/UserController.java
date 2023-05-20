package com.example.vijuserver.users.controller;

import com.example.vijuserver.error.UserNotFoundException;
import com.example.vijuserver.users.dto.CreateUserDto;
import com.example.vijuserver.users.dto.GetUserDto;
import com.example.vijuserver.users.dto.UserDtoConverter;
import com.example.vijuserver.users.model.UserEntity;
import com.example.vijuserver.users.services.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserEntityService userService;
    private final UserDtoConverter userDtoConverter;

    @GetMapping("/users")
    public ResponseEntity<List<UserEntity>> findAll(){
        List<UserEntity> users = userService.findAll();
        if(users.isEmpty()){
            throw new UserNotFoundException();
        }
        return ResponseEntity.ok(users);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<UserEntity> findById(@PathVariable Long id) {
        UserEntity user = userService.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return ResponseEntity.ok(user);
    }
    @PutMapping("/user/{id}")
    public ResponseEntity<UserEntity> update(@PathVariable Long id, @RequestBody UserEntity user) {
        Optional<UserEntity> userCurrent = userService.findById(id);
        if (userCurrent.isPresent()) {
            user.setId(id);
            user.setCreatedAt(userCurrent.get().getCreatedAt());
            UserEntity userUpdated = userService.modify(user);
            return new ResponseEntity<>(userUpdated, HttpStatus.OK);
        } else {
            throw new UserNotFoundException(id);
        }
    }
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
    @PostMapping("/user")
    public ResponseEntity<GetUserDto> newUser(@RequestBody CreateUserDto newUser){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                userDtoConverter.convertUserEntityToGetUserDto(
                        userService.newUser(newUser)));
    }
}
