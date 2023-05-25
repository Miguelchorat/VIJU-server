package com.example.vijuserver.repository;

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
    Page<Review> findByTitleContainingAndScoreBetweenAndVideogameNameIn(
            String title, Integer minScore, Integer maxScore, List<String> videogameNames, Pageable pageable);

    Page<Review> findByTitleContainingAndScoreBetweenAndVideogameNameInAndCreatedAtBetween(
            String title, Integer minScore, Integer maxScore, List<String> videogameNames, LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);

    Page<Review> findByTitleContainingAndScoreBetween(
            String title, Integer minScore, Integer maxScore, Pageable pageable);

    Page<Review> findByTitleContainingAndScoreBetweenAndCreatedAtBetween(
            String title, Integer minScore, Integer maxScore, LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);

    Page<Review> findByTitleContainingAndVideogameNameIn(
            String title, List<String> videogameNames, Pageable pageable);

    Page<Review> findByTitleContainingAndVideogameNameInAndCreatedAtBetween(
            String title, List<String> videogameNames, LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);

    Page<Review> findByTitleContaining(String title, Pageable pageable);

    Page<Review> findByTitleContainingAndCreatedAtBetween(String title, LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);

    Page<Review> findByScoreBetweenAndVideogameNameIn(
            Integer minScore, Integer maxScore, List<String> videogameNames, Pageable pageable);

    Page<Review> findByScoreBetweenAndVideogameNameInAndCreatedAtBetween(
            Integer minScore, Integer maxScore, List<String> videogameNames, LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);

    Page<Review> findByScoreBetween(
            Integer minScore, Integer maxScore, Pageable pageable);

    Page<Review> findByScoreBetweenAndCreatedAtBetween(
            Integer minScore, Integer maxScore, LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);

    Page<Review> findByVideogameNameIn(List<String> videogameNames, Pageable pageable);

    Page<Review> findByVideogameNameInAndCreatedAtBetween(List<String> videogameNames, LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);

    Page<Review> findByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);

    int countByUser_Id(Long userId);
}
