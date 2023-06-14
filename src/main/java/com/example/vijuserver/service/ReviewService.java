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
/**
 * Servicio de review conecta las peticiones del controlador con el repositorio
 */
@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    /**
     * Lista las reseñas sin ningun tipo de filtro
     * @return
     */
    public List<Review> findAll(){
        return reviewRepository.findAll();
    }
    public Optional<Review> findById(Long id){
        return reviewRepository.findById(id);
    }

    /**
     * Guarda una review
     * @param review
     * @return
     */
    public Review save(Review review){
        review.setCreatedAt(LocalDateTime.now());
        review.setUpdatedAt(LocalDateTime.now());
        return reviewRepository.save(review);
    }

    /**
     * Modifica una review
     * @param review
     * @return
     */
    public Review modify(Review review){
        review.setUpdatedAt(LocalDateTime.now());
        return reviewRepository.save(review);
    }

    /**
     * Elimina una review por su id
     * @param id
     */
    public void deleteById(Long id){
        reviewRepository.deleteById(id);
    }

    /**
     * Realiza una lista de reviews que corresponda con los filtros en los parametros
     * @param title
     * @param minScore
     * @param maxScore
     * @param videogameNames
     * @param startDate
     * @param endDate
     * @param username
     * @param pageable
     * @return
     */
    public Page<Review> findByTitleContainingAndScoreBetweenAndVideogameNameInAndCreatedAtBetweenAndUserUsernameContaining(
            String title, Integer minScore, Integer maxScore, List<String> videogameNames, LocalDateTime startDate, LocalDateTime endDate,String username, Pageable pageable) {
        return reviewRepository.findByTitleContainingAndScoreBetweenAndVideogameNameInAndCreatedAtBetweenAndUserUsernameContaining(
                title, minScore, maxScore, videogameNames,startDate, endDate,username, pageable);
    }

    /**
     * Realiza una lista de reviews que corresponda con los filtros en los parametros
     * @param title
     * @param minScore
     * @param maxScore
     * @param videogameNames
     * @param startDate
     * @param endDate
     * @param username
     * @param likes
     * @param pageable
     * @return
     */
    public Page<Review> findByTitleContainingAndScoreBetweenAndVideogameNameInAndCreatedAtBetweenAndUserUsernameContainingAndUserLikes(
            String title, Integer minScore, Integer maxScore, List<String> videogameNames, LocalDateTime startDate, LocalDateTime endDate,String username, List<Like> likes, Pageable pageable) {
        return reviewRepository.findByTitleContainingAndScoreBetweenAndVideogameNameInAndCreatedAtBetweenAndUserUsernameContainingAndLikesIn(
               title, minScore, maxScore, videogameNames,startDate, endDate,username,likes, pageable);
    }

    /**
     * Realiza una lista de reviews que corresponda con los filtros en los parametros
     * @param title
     * @param minScore
     * @param maxScore
     * @param videogameNames
     * @param startDate
     * @param endDate
     * @param username
     * @param favorites
     * @param pageable
     * @return
     */
    public Page<Review> findByTitleContainingAndScoreBetweenAndVideogameNameInAndCreatedAtBetweenAndUserUsernameContainingAndUserFavorites(
            String title, Integer minScore, Integer maxScore, List<String> videogameNames, LocalDateTime startDate, LocalDateTime endDate, String username, List<Favorite> favorites, Pageable pageable) {
        return reviewRepository.findByTitleContainingAndScoreBetweenAndVideogameNameInAndCreatedAtBetweenAndUserUsernameContainingAndFavoritesIn(
                title, minScore, maxScore, videogameNames,startDate, endDate, username,favorites, pageable);
    }

    /**
     * Realiza una lista de reviews que corresponda con los filtros en los parametros
     * @param title
     * @param minScore
     * @param maxScore
     * @param startDate
     * @param endDate
     * @param username
     * @param pageable
     * @return
     */
    public Page<Review> findByTitleContainingAndScoreBetweenAndCreatedAtBetweenAndUserUsernameContaining(
            String title, Integer minScore, Integer maxScore, LocalDateTime startDate, LocalDateTime endDate,String username, Pageable pageable) {
        return reviewRepository.findByTitleContainingAndScoreBetweenAndCreatedAtBetweenAndUserUsernameContaining(
                title, minScore, maxScore,startDate, endDate,username, pageable);
    }

    /**
     * Realiza una lista de reviews que corresponda con los filtros en los parametros
     * @param title
     * @param minScore
     * @param maxScore
     * @param startDate
     * @param endDate
     * @param username
     * @param likes
     * @param pageable
     * @return
     */
    public Page<Review> findByTitleContainingAndScoreBetweenAndCreatedAtBetweenAndUserUsernameContainingAndUserLikes(
            String title, Integer minScore, Integer maxScore, LocalDateTime startDate, LocalDateTime endDate, String username, List<Like> likes, Pageable pageable) {
        return reviewRepository.findByTitleContainingAndScoreBetweenAndCreatedAtBetweenAndUserUsernameContainingAndLikesIn(
                title, minScore, maxScore,startDate, endDate, username,likes, pageable);
    }

    /**
     * Realiza una lista de reviews que corresponda con los filtros en los parametros
     * @param title
     * @param minScore
     * @param maxScore
     * @param startDate
     * @param endDate
     * @param username
     * @param favorites
     * @param pageable
     * @return
     */
    public Page<Review> findByTitleContainingAndScoreBetweenAndCreatedAtBetweenAndUserUsernameContainingAndUserFavorites(
            String title, Integer minScore, Integer maxScore, LocalDateTime startDate, LocalDateTime endDate,String username,List<Favorite> favorites, Pageable pageable) {
        return reviewRepository.findByTitleContainingAndScoreBetweenAndCreatedAtBetweenAndUserUsernameContainingAndFavoritesIn(
                title, minScore, maxScore,startDate, endDate,username,favorites,pageable);
    }

    /**
     * Cuenta cuantas reviews realizo un usuario en concreto
     * @param userId
     * @return
     */
    public int countReviewsByUserId(Long userId) {
        return reviewRepository.countByUser_Id(userId);
    }
}
