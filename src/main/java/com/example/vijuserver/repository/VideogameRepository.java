package com.example.vijuserver.repository;

import com.example.vijuserver.model.Videogame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface VideogameRepository extends JpaRepository<Videogame, Long>, JpaSpecificationExecutor<Videogame> {
    List<Videogame> findByNameContainingIgnoreCase(String name);
}
