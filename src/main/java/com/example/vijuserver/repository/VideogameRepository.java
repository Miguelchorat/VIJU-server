package com.example.vijuserver.repository;

import com.example.vijuserver.model.Videogame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
/**
 * Repositorio de videojuegos donde se hará la busqueda en la base de datos
 */
public interface VideogameRepository extends JpaRepository<Videogame, Long>, JpaSpecificationExecutor<Videogame> {
    List<Videogame> findByNameContainingIgnoreCase(String name);
}
