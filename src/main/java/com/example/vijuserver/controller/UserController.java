package com.example.vijuserver.controller;

import com.example.vijuserver.error.UserNotFoundException;
import com.example.vijuserver.model.User;
import com.example.vijuserver.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> findAll(){
        List<User> users = userService.findAll();
        if(users.isEmpty()){
            throw new UserNotFoundException();
        }
        return ResponseEntity.ok(users);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = userService.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return ResponseEntity.ok(user);
    }
    @PostMapping("/user")
    public ResponseEntity<User> save(@RequestBody User user) {
        user.setId(null);
        user = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
    @PutMapping("/user/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
        Optional<User> userCurrent = userService.findById(id);
        if (userCurrent.isPresent()) {
            user.setId(id);
            user.setCreated_at(userCurrent.get().getCreated_at());
            User userUpdated = userService.modify(user);
            return new ResponseEntity<>(userUpdated, HttpStatus.OK);
        } else {
            throw new UserNotFoundException(id);
        }
    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);
        if (user.isPresent()) {
            userService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            throw new UserNotFoundException(id);
        }
    }
}
