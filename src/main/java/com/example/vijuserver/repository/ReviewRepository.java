package com.example.vijuserver.repository;

import com.example.vijuserver.model.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long>, JpaSpecificationExecutor<Review> {
    Page<Review> findByTitleContainingAndScoreBetweenAndVideogameNameIn(
            String title, Integer minScore, Integer maxScore, List<String> videogameNames, Pageable pageable);

    Page<Review> findByTitleContainingAndScoreBetween(
            String title, Integer minScore, Integer maxScore, Pageable pageable);

    Page<Review> findByTitleContainingAndVideogameNameIn(
            String title, List<String> videogameNames, Pageable pageable);

    Page<Review> findByTitleContaining(String title, Pageable pageable);

    Page<Review> findByScoreBetweenAndVideogameNameIn(
            Integer minScore, Integer maxScore, List<String> videogameNames, Pageable pageable);

    Page<Review> findByScoreBetween(
            Integer minScore, Integer maxScore, Pageable pageable);

    Page<Review> findByVideogameNameIn(List<String> videogameNames, Pageable pageable);
}
