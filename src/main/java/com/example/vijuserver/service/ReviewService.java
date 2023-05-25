package com.example.vijuserver.service;

import com.example.vijuserver.model.Review;
import com.example.vijuserver.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> findAll(){
        return reviewRepository.findAll();
    }
    public Optional<Review> findById(Long id){
        return reviewRepository.findById(id);
    }
    public Review save(Review review){
        review.setCreatedAt(LocalDateTime.now());
        review.setUpdatedAt(LocalDateTime.now());
        return reviewRepository.save(review);
    }
    public Review modify(Review review){
        review.setUpdatedAt(LocalDateTime.now());
        return reviewRepository.save(review);
    }
    public void deleteById(Long id){
        reviewRepository.deleteById(id);
    }
    public Page<Review> findByTitleContainingAndScoreBetweenAndVideogameNameIn(
            String title, Integer minScore, Integer maxScore, List<String> videogameNames, Pageable pageable) {
        return reviewRepository.findByTitleContainingAndScoreBetweenAndVideogameNameIn(
                title, minScore, maxScore, videogameNames, pageable);
    }

    public Page<Review> findByTitleContainingAndScoreBetween(
            String title, Integer minScore, Integer maxScore, Pageable pageable) {
        return reviewRepository.findByTitleContainingAndScoreBetween(
                title, minScore, maxScore, pageable);
    }

    public Page<Review> findByTitleContainingAndVideogameNameIn(
            String title, List<String> videogameNames, Pageable pageable) {
        return reviewRepository.findByTitleContainingAndVideogameNameIn(title, videogameNames, pageable);
    }

    public Page<Review> findByTitleContaining(String title, Pageable pageable) {
        return reviewRepository.findByTitleContaining(title, pageable);
    }

    public Page<Review> findByScoreBetweenAndVideogameNameIn(
            Integer minScore, Integer maxScore, List<String> videogameNames, Pageable pageable) {
        return reviewRepository.findByScoreBetweenAndVideogameNameIn(minScore, maxScore, videogameNames, pageable);
    }

    public Page<Review> findByScoreBetween(
            Integer minScore, Integer maxScore, Pageable pageable) {
        return reviewRepository.findByScoreBetween(minScore, maxScore, pageable);
    }

    public Page<Review> findByVideogameNameIn(List<String> videogameNames, Pageable pageable) {
        return reviewRepository.findByVideogameNameIn(videogameNames, pageable);
    }
    public Page<Review> findAll(Pageable pageable) {
        return reviewRepository.findAll(pageable);
    }

    public Page<Review> findByTitleContainingAndScoreBetweenAndVideogameNameInAndCreatedAtBetween(
            String title, Integer minScore, Integer maxScore, List<String> videogameNames, LocalDateTime startDate, LocalDateTime endDate, Pageable pageable) {
        return reviewRepository.findByTitleContainingAndScoreBetweenAndVideogameNameInAndCreatedAtBetween(
                title, minScore, maxScore, videogameNames,startDate, endDate, pageable);
    }

    public Page<Review> findByTitleContainingAndScoreBetweenAndCreatedAtBetween(
            String title, Integer minScore, Integer maxScore, LocalDateTime startDate, LocalDateTime endDate, Pageable pageable) {
        return reviewRepository.findByTitleContainingAndScoreBetweenAndCreatedAtBetween(
                title, minScore, maxScore,startDate, endDate, pageable);
    }

    public Page<Review> findByTitleContainingAndVideogameNameInAndCreatedAtBetween(
            String title, List<String> videogameNames, LocalDateTime startDate, LocalDateTime endDate, Pageable pageable) {
        return reviewRepository.findByTitleContainingAndVideogameNameInAndCreatedAtBetween(title, videogameNames,startDate, endDate, pageable);
    }

    public Page<Review> findByTitleContainingAndCreatedAtBetween(String title, LocalDateTime startDate, LocalDateTime endDate, Pageable pageable) {
        return reviewRepository.findByTitleContainingAndCreatedAtBetween(title,startDate, endDate,  pageable);
    }

    public Page<Review> findByScoreBetweenAndVideogameNameInAndCreatedAtBetween(
            Integer minScore, Integer maxScore, List<String> videogameNames, LocalDateTime startDate, LocalDateTime endDate, Pageable pageable) {
        return reviewRepository.findByScoreBetweenAndVideogameNameInAndCreatedAtBetween(minScore, maxScore,  videogameNames, startDate, endDate, pageable);
    }

    public Page<Review> findByScoreBetweenAndCreatedAtBetween(
            Integer minScore, Integer maxScore, LocalDateTime startDate, LocalDateTime endDate, Pageable pageable) {
        return reviewRepository.findByScoreBetweenAndCreatedAtBetween(minScore, maxScore, startDate, endDate, pageable);
    }

    public Page<Review> findByVideogameNameInAndCreatedAtBetween(List<String> videogameNames, LocalDateTime startDate, LocalDateTime endDate, Pageable pageable) {
        return reviewRepository.findByVideogameNameInAndCreatedAtBetween(videogameNames, startDate, endDate, pageable);
    }

    public Page<Review> findByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate, Pageable pageable) {
        return reviewRepository.findByCreatedAtBetween( startDate, endDate, pageable);
    }

    public int countReviewsByUserId(Long userId) {
        return reviewRepository.countByUser_Id(userId);
    }
}
