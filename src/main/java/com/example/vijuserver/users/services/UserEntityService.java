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

/**
 * Servicio que conecta el controlador con el repositorio
 */
@Service
@RequiredArgsConstructor
public class UserEntityService {
    @Autowired
    private UserEntityRepository userEntityRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * Hace un listado de todos los usuarios
     * @return
     */
    public List<UserEntity> findAll(){
        return userEntityRepository.findAll();
    }

    /**
     * Busca un usuario por su id
     * @param id
     * @return
     */
    public Optional<UserEntity> findById(Long id){
        return userEntityRepository.findById(id);
    }

    /**
     * Crea un nuevo usuario
     * @param user
     * @return
     */
    public UserEntity save(UserEntity user){
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        return userEntityRepository.save(user);
    }

    /**
     * Modifica un usuario
     * @param user
     * @return
     */
    public UserEntity modify(UserEntity user){
        user.setUpdatedAt(LocalDateTime.now());
        return userEntityRepository.save(user);
    }

    /**
     * Modifica el usuario con los datos correspondientes y los compruebas para ver si todo es correcto.
     * @param user
     * @param newUser
     * @return
     */
    public UserEntity modifyUser(UserEntity user,CreateUserDto newUser){
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
            boolean isUsernameDuplicate = false;
            boolean isEmailDuplicate = false;

            if(!user.getUsername().equalsIgnoreCase(newUser.getUsername())){
                isUsernameDuplicate = checkIfUsernameExists(newUser.getUsername());
            }
            if(!user.getEmail().equalsIgnoreCase(newUser.getEmail())) {
                isEmailDuplicate = checkIfEmailExists(newUser.getEmail());
            }

            if (isUsernameDuplicate && isEmailDuplicate) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre de usuario y el correo electrónico ya existen");
            } else if (isUsernameDuplicate) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre de usuario ya existe");
            } else if (isEmailDuplicate) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El correo electrónico ya existe");
            }

            try {
                user.setEmail(newUser.getEmail());
                user.setUsername(newUser.getUsername());
                user.setPassword(passwordEncoder.encode(newUser.getPassword()));
                user.setUpdatedAt(LocalDateTime.now());
                return save(user);
            } catch (DataIntegrityViolationException ex) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al crear el usuario");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Las contraseñas no coinciden");
        }
    }

    /**
     * Elimina un usuario por su id
     * @param id
     */
    public void deleteById(Long id){
        userEntityRepository.deleteById(id);
    }

    /**
     * Busca un usuario por su nombre de usuario
     * @param username
     * @return
     */
    public Optional<UserEntity> findByUsername(String username) {
        return this.userEntityRepository.findByUsername(username);
    }

    /**
     * Crea un nuevo usuario comprobando que todos los campos sean correctos
     * @param newUser
     * @return
     */
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

    /**
     * Chequea si el nombre de usuario ya existe en la base de datos
     * @param username
     * @return
     */
    private boolean checkIfUsernameExists(String username) {
        Optional<UserEntity> existingUser = userEntityRepository.findByUsername(username);
        return existingUser.isPresent();
    }

    /**
     * Chequea si el correo del usuario ya existe en la base de datoss
     * @param email
     * @return
     */
    private boolean checkIfEmailExists(String email) {
        Optional<UserEntity> existingUser = userEntityRepository.findByEmail(email);
        return existingUser.isPresent();
    }
}
