package com.example.vijuserver.service;

import com.example.vijuserver.model.Favorite;
import com.example.vijuserver.model.Like;
import com.example.vijuserver.model.Review;
import com.example.vijuserver.repository.FavoriteRepository;
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

/**
 * Servicio de favorito conecta las peticiones del controlador con el repositorio
 */
@Service
public class FavoriteService {
    @Autowired
    private FavoriteRepository favoriteRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    public int countFavoritesByUserId(Long userId) {
        return favoriteRepository.countByUser_Id(userId);
    }

    public boolean existsByUserIdAndReviewId(Long userId,Long reviewId) {
        return favoriteRepository.existsByUserIdAndReviewId(userId,reviewId);
    }

    /**
     * Añade un favorito de la review seleccionada
     * @param user
     * @param reviewId
     */
    public void addFavorite(UserEntity user, Long reviewId) {
        Optional<Review> reviewOptional = reviewRepository.findById(reviewId);

        if (reviewOptional.isPresent()) {
            Review review = reviewOptional.get();

            Favorite favorite = new Favorite();
            favorite.setUser(user);
            favorite.setReview(review);
            favorite.setCreated_at(LocalDateTime.now());

            favoriteRepository.save(favorite);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Hubo un error inesperado");
        }
    }

    /**
     * Elimina un favorito de la review seleccionada
     * @param userId
     * @param reviewId
     */
    public void removeFavorite(Long userId, Long reviewId) {
        Optional<Favorite> favoriteOptional = favoriteRepository.findByUserIdAndReviewId(userId, reviewId);
        favoriteOptional.ifPresent(favoriteRepository::delete);
    }
}
