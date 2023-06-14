package com.example.vijuserver.users.repository;

import com.example.vijuserver.users.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repositorio del usuario para buscar por nombre o email
 */
public interface UserEntityRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findByUsername(String username);
    Optional<UserEntity> findByEmail(String email);

}
