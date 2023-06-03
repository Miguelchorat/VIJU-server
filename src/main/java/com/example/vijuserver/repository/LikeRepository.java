package com.example.vijuserver.repository;

import com.example.vijuserver.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long>, JpaSpecificationExecutor<Like> {
    int countByUser_Id(Long userId);
    boolean existsByUserIdAndReviewId(Long userId,Long reviewId);

    Optional<Like> findByUserIdAndReviewId(Long userId, Long reviewId);
}
