package com.example.vijuserver.repository;

import com.example.vijuserver.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FavoriteRepository extends JpaRepository<Favorite, Long>, JpaSpecificationExecutor<Favorite> {
}
