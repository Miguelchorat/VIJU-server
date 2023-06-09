package com.example.vijuserver.repository;

import com.example.vijuserver.model.Favorite;
import com.example.vijuserver.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite, Long>, JpaSpecificationExecutor<Favorite> {
    int countByUser_Id(Long userId);
    // existsByUserIdAndReviewId(Long userId,Long reviewId);

    Optional<Favorite> findByUserIdAndReviewId(Long userId, Long reviewId);


    @Query(value = "SELECT COUNT(*) FROM favorites WHERE user_id = :userId AND review_id = :reviewId", nativeQuery = true)
    int countByUserIdAndReviewId(@Param("userId") Long userId, @Param("reviewId") Long reviewId);

    default boolean existsByUserIdAndReviewId(Long userId, Long reviewId) {
        int count = countByUserIdAndReviewId(userId, reviewId);
        return count > 0;
    }
}
