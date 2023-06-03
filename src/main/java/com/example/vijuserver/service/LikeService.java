package com.example.vijuserver.service;

import com.example.vijuserver.error.UserNotFoundException;
import com.example.vijuserver.model.Like;
import com.example.vijuserver.model.Review;
import com.example.vijuserver.repository.LikeRepository;
import com.example.vijuserver.repository.ReviewRepository;
import com.example.vijuserver.users.model.UserEntity;
import com.example.vijuserver.users.services.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LikeService {
    @Autowired
    private LikeRepository likeRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    public int countLikesByUserId(Long userId) {
        return likeRepository.countByUser_Id(userId);
    }

    public boolean existsByUserIdAndReviewId(Long userId,Long reviewId) {
        return likeRepository.existsByUserIdAndReviewId(userId,reviewId);
    }

    public void addLike(UserEntity user, Long reviewId) {
        Optional<Review> reviewOptional = reviewRepository.findById(reviewId);

        if (reviewOptional.isPresent()) {
            Review review = reviewOptional.get();

            Like like = new Like();
            like.setUser(user);
            like.setReview(review);
            like.setCreated_at(LocalDateTime.now());

            try {
                likeRepository.save(like);
            } catch (Exception e) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al guardar el like", e);
            }
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Hubo un error inesperado");
        }
    }

    public void removeLike(Long userId, Long reviewId) {
        Optional<Like> likeOptional = likeRepository.findByUserIdAndReviewId(userId, reviewId);
        likeOptional.ifPresent(likeRepository::delete);
    }
}
