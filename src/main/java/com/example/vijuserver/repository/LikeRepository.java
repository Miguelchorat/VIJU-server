package com.example.vijuserver.repository;

import com.example.vijuserver.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long>, JpaSpecificationExecutor<Like> {
    int countByUser_Id(Long userId);
    //boolean existsByUserIdAndReviewId(Long userId,Long reviewId);

    Optional<Like> findByUserIdAndReviewId(Long userId, Long reviewId);

    @Query(value = "SELECT COUNT(*) FROM likes WHERE user_id = :userId AND review_id = :reviewId", nativeQuery = true)
    int countByUserIdAndReviewId(@Param("userId") Long userId, @Param("reviewId") Long reviewId);

    default boolean existsByUserIdAndReviewId(Long userId, Long reviewId) {
        int count = countByUserIdAndReviewId(userId, reviewId);
        return count > 0;
    }
}
