package com.example.vijuserver.service;

import com.example.vijuserver.model.Review;
import com.example.vijuserver.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
}
