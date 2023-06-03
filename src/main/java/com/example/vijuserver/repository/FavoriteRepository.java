package com.example.vijuserver.repository;

import com.example.vijuserver.model.Favorite;
import com.example.vijuserver.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite, Long>, JpaSpecificationExecutor<Favorite> {
    int countByUser_Id(Long userId);
    boolean existsByUserIdAndReviewId(Long userId,Long reviewId);

    Optional<Favorite> findByUserIdAndReviewId(Long userId, Long reviewId);
}
