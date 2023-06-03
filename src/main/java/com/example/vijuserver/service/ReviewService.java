package com.example.vijuserver.service;

import com.example.vijuserver.model.Favorite;
import com.example.vijuserver.model.Like;
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
    public Page<Review> findByTitleContainingAndScoreBetweenAndVideogameNameInAndCreatedAtBetweenAndUserUsernameContaining(
            String title, Integer minScore, Integer maxScore, List<String> videogameNames, LocalDateTime startDate, LocalDateTime endDate,String username, Pageable pageable) {
        return reviewRepository.findByTitleContainingAndScoreBetweenAndVideogameNameInAndCreatedAtBetweenAndUserUsernameContaining(
                title, minScore, maxScore, videogameNames,startDate, endDate,username, pageable);
    }

    public Page<Review> findByTitleContainingAndScoreBetweenAndVideogameNameInAndCreatedAtBetweenAndUserUsernameContainingAndUserLikes(
            String title, Integer minScore, Integer maxScore, List<String> videogameNames, LocalDateTime startDate, LocalDateTime endDate,String username, List<Like> likes, Pageable pageable) {
        return reviewRepository.findByTitleContainingAndScoreBetweenAndVideogameNameInAndCreatedAtBetweenAndUserUsernameContainingAndLikesIn(
               title, minScore, maxScore, videogameNames,startDate, endDate,username,likes, pageable);
    }

    public Page<Review> findByTitleContainingAndScoreBetweenAndVideogameNameInAndCreatedAtBetweenAndUserUsernameContainingAndUserFavorites(
            String title, Integer minScore, Integer maxScore, List<String> videogameNames, LocalDateTime startDate, LocalDateTime endDate, String username, List<Favorite> favorites, Pageable pageable) {
        return reviewRepository.findByTitleContainingAndScoreBetweenAndVideogameNameInAndCreatedAtBetweenAndUserUsernameContainingAndFavoritesIn(
                title, minScore, maxScore, videogameNames,startDate, endDate, username,favorites, pageable);
    }

    public Page<Review> findByTitleContainingAndScoreBetweenAndCreatedAtBetweenAndUserUsernameContaining(
            String title, Integer minScore, Integer maxScore, LocalDateTime startDate, LocalDateTime endDate,String username, Pageable pageable) {
        return reviewRepository.findByTitleContainingAndScoreBetweenAndCreatedAtBetweenAndUserUsernameContaining(
                title, minScore, maxScore,startDate, endDate,username, pageable);
    }

    public Page<Review> findByTitleContainingAndScoreBetweenAndCreatedAtBetweenAndUserUsernameContainingAndUserLikes(
            String title, Integer minScore, Integer maxScore, LocalDateTime startDate, LocalDateTime endDate, String username, List<Like> likes, Pageable pageable) {
        return reviewRepository.findByTitleContainingAndScoreBetweenAndCreatedAtBetweenAndUserUsernameContainingAndLikesIn(
                title, minScore, maxScore,startDate, endDate, username,likes, pageable);
    }

    public Page<Review> findByTitleContainingAndScoreBetweenAndCreatedAtBetweenAndUserUsernameContainingAndUserFavorites(
            String title, Integer minScore, Integer maxScore, LocalDateTime startDate, LocalDateTime endDate,String username,List<Favorite> favorites, Pageable pageable) {
        return reviewRepository.findByTitleContainingAndScoreBetweenAndCreatedAtBetweenAndUserUsernameContainingAndFavoritesIn(
                title, minScore, maxScore,startDate, endDate,username,favorites,pageable);
    }

    public int countReviewsByUserId(Long userId) {
        return reviewRepository.countByUser_Id(userId);
    }
}
