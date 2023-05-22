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
        if (!newUser.getEmail().matches("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Correo electrónico no válido");
        }
        if (!newUser.getUsername().matches("^[a-zA-Z\\d]{3,18}$")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nombre de usuario no válido");
        }
        if (!newUser.getPassword().matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,32}$")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Contraseña no válida");
        }
        if(newUser.getPassword().contentEquals(newUser.getPassword2())){
            UserEntity userEntity = UserEntity.builder()
                    .username(newUser.getUsername())
                    .password(passwordEncoder.encode(newUser.getPassword()))
                    .avatar("1.svg")
                    .email(newUser.getEmail())
                    .role(UserRole.USER)
                    .build();

            boolean isUsernameDuplicate = checkIfUsernameExists(newUser.getUsername());
            boolean isEmailDuplicate = checkIfEmailExists(newUser.getEmail());

            if (isUsernameDuplicate && isEmailDuplicate) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre de usuario y el correo electrónico ya existen");
            } else if (isUsernameDuplicate) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre de usuario ya existe");
            } else if (isEmailDuplicate) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El correo electrónico ya existe");
            }

            try {
                return save(userEntity);
            } catch (DataIntegrityViolationException ex) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al crear el usuario");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Las contraseñas no coinciden");
        }
    }

    private boolean checkIfUsernameExists(String username) {
        Optional<UserEntity> existingUser = userEntityRepository.findByUsername(username);
        return existingUser.isPresent();
    }

    private boolean checkIfEmailExists(String email) {
        Optional<UserEntity> existingUser = userEntityRepository.findByEmail(email);
        return existingUser.isPresent();
    }
}
