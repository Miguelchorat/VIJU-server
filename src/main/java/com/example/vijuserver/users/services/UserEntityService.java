package com.example.vijuserver.users.services;

import com.example.vijuserver.error.exceptions.NewUserWithDifferentPasswordsException;
import com.example.vijuserver.users.dto.CreateUserDto;
import com.example.vijuserver.users.model.UserEntity;
import com.example.vijuserver.users.model.UserRole;
import com.example.vijuserver.users.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class UserEntityService {
    @Autowired
    private UserEntityRepository userEntityRepository;
    private final PasswordEncoder passwordEncoder;
    public List<UserEntity> findAll(){
        return userEntityRepository.findAll();
    }
    public Optional<UserEntity> findById(Long id){
        return userEntityRepository.findById(id);
    }
    public UserEntity save(UserEntity user){
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        return userEntityRepository.save(user);
    }
    public UserEntity modify(UserEntity user){
        user.setUpdatedAt(LocalDateTime.now());
        return userEntityRepository.save(user);
    }
    public void deleteById(Long id){
        userEntityRepository.deleteById(id);
    }

    public Optional<UserEntity> findByUsername(String username) {
        return this.userEntityRepository.findByUsername(username);
    }

    public UserEntity newUser(CreateUserDto newUser){
        if(newUser.getPassword().contentEquals(newUser.getPassword2())){
            UserEntity userEntity = UserEntity.builder()
                    .username(newUser.getUsername())
                    .password(passwordEncoder.encode(newUser.getPassword()))
                    .avatar(newUser.getAvatar())
                    .email(newUser.getEmail())
                    .role(UserRole.USER)
                    .build();

            try {
                return save(userEntity);
            } catch (DataIntegrityViolationException ex) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre de usuario ya existe");
            }
        } else {
            throw new NewUserWithDifferentPasswordsException();
        }
    }
}
