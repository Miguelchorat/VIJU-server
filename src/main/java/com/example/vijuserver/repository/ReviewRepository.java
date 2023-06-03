package com.example.vijuserver.repository;

import com.example.vijuserver.model.Favorite;
import com.example.vijuserver.model.Like;
import com.example.vijuserver.model.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long>, JpaSpecificationExecutor<Review> {
    Page<Review> findByTitleContainingAndScoreBetweenAndVideogameNameInAndCreatedAtBetweenAndUserUsernameContaining(
            String title, Integer minScore, Integer maxScore, List<String> videogameNames,LocalDateTime startDate, LocalDateTime endDate,String username, Pageable pageable);

    Page<Review> findByTitleContainingAndScoreBetweenAndVideogameNameInAndCreatedAtBetweenAndUserUsernameContainingAndLikesIn(
            String title, Integer minScore, Integer maxScore, List<String> videogameNames,LocalDateTime startDate, LocalDateTime endDate,String username,List<Like> likes,  Pageable pageable);

    Page<Review> findByTitleContainingAndScoreBetweenAndVideogameNameInAndCreatedAtBetweenAndUserUsernameContainingAndFavoritesIn(
            String title, Integer minScore, Integer maxScore, List<String> videogameNames, LocalDateTime startDate, LocalDateTime endDate, String username, List<Favorite> favorites, Pageable pageable);

    Page<Review> findByTitleContainingAndScoreBetweenAndCreatedAtBetweenAndUserUsernameContaining(
            String title, Integer minScore, Integer maxScore,LocalDateTime startDate, LocalDateTime endDate,String username, Pageable pageable);

    Page<Review> findByTitleContainingAndScoreBetweenAndCreatedAtBetweenAndUserUsernameContainingAndLikesIn(
            String title, Integer minScore, Integer maxScore, LocalDateTime startDate, LocalDateTime endDate, String username, List<Like> likes, Pageable pageable);

    Page<Review> findByTitleContainingAndScoreBetweenAndCreatedAtBetweenAndUserUsernameContainingAndFavoritesIn(
            String title, Integer minScore, Integer maxScore,LocalDateTime startDate, LocalDateTime endDate,String username,List<Favorite> favorites,  Pageable pageable);

    int countByUser_Id(Long userId);
}
