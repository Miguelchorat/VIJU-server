package com.example.vijuserver.controller;

import com.example.vijuserver.dto.ReviewDto;
import com.example.vijuserver.error.ReviewNotFoundException;
import com.example.vijuserver.error.VideogameNotFoundException;
import com.example.vijuserver.model.Review;
import com.example.vijuserver.model.Videogame;
import com.example.vijuserver.security.jwt.JwtProvider;
import com.example.vijuserver.service.ReviewService;
import com.example.vijuserver.service.VideogameService;
import com.example.vijuserver.users.dto.UserDtoConverter;
import com.example.vijuserver.users.model.UserEntity;
import com.example.vijuserver.users.services.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;
    private final JwtProvider tokenProvider;
    private final UserDtoConverter userDtoConverter;
    private final UserEntityService userService;
    private final VideogameService videogameService;

    @GetMapping("/reviews")
    public ResponseEntity<Page<ReviewDto>> findAllWithFilters(@RequestParam(defaultValue = "0") int page,
                                                           @RequestParam(defaultValue = "16") int size,
                                                           @RequestParam(required = false) String search,
                                                           @RequestParam(defaultValue = "0") Integer minScore,
                                                           @RequestParam(defaultValue = "5") Integer maxScore,
                                                           @RequestParam(required = false) List<String> videogames){
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<Review> reviews;

        if(search != null && !search.isEmpty()){
            if(minScore != null && maxScore != null && videogames != null){
                reviews = reviewService.findByTitleContainingAndScoreBetweenAndVideogameNameIn(
                        search, minScore, maxScore, videogames, pageable);
            }
            else if(minScore != null && maxScore != null){
                reviews = reviewService.findByTitleContainingAndScoreBetween(
                        search, minScore, maxScore, pageable);
            }
            else if(videogames != null){
                reviews = reviewService.findByTitleContainingAndVideogameNameIn(
                        search, videogames, pageable);
            }
            else{
                reviews = reviewService.findByTitleContaining(search, pageable);
            }
        }
        else{
            if(minScore != null && maxScore != null && videogames != null){
                reviews = reviewService.findByScoreBetweenAndVideogameNameIn(
                        minScore, maxScore, videogames, pageable);
            }
            else if(minScore != null && maxScore != null){
                reviews = reviewService.findByScoreBetween(
                        minScore, maxScore, pageable);
            }
            else if(videogames != null){
                reviews = reviewService.findByVideogameNameIn(
                        videogames, pageable);
            }
            else{
                reviews = reviewService.findAll(pageable);
            }
        }
        List<ReviewDto> reviewDtos = reviews.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

        Page<ReviewDto> reviewDtoPage = new PageImpl<>(reviewDtos, pageable, reviews.getTotalElements());
        return ResponseEntity.ok(reviewDtoPage);
    }

    @GetMapping("/reviewsDate")
    public ResponseEntity<Page<ReviewDto>> findAllWithFilters(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "8") int size,
            @RequestParam(required = false) String search,
            @RequestParam(defaultValue = "0") Integer minScore,
            @RequestParam(defaultValue = "5") Integer maxScore,
            @RequestParam(required = false) List<String> videogames,
            @RequestParam(required = false) String timeframe
    ) {
        Pageable pageable;

        if (timeframe != null && !timeframe.isEmpty()) {
            LocalDateTime startDate;
            LocalDateTime endDate = LocalDateTime.now(); // Fecha actual

            // Calcular la fecha de inicio según el periodo de tiempo
            if (timeframe.equals("day")) {
                startDate = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
            } else if (timeframe.equals("week")) {
                startDate = endDate.minusWeeks(1).with(LocalTime.MIN);
            } else if (timeframe.equals("month")) {
                startDate = endDate.minusMonths(1).with(LocalTime.MIN);
            } else {
                // Valor de timeframe no válido, retornar una respuesta de error
                return ResponseEntity.badRequest().build();
            }

            pageable = PageRequest.of(page, size, Sort.by("likeCount").descending());
            Page<Review> reviews;

            if (search != null && !search.isEmpty()) {
                if (minScore != null && maxScore != null && videogames != null) {
                    reviews = reviewService.findByTitleContainingAndScoreBetweenAndVideogameNameInAndCreatedAtBetween(
                            search, minScore, maxScore, videogames, startDate, endDate, pageable);
                } else if (minScore != null && maxScore != null) {
                    reviews = reviewService.findByTitleContainingAndScoreBetweenAndCreatedAtBetween(
                            search, minScore, maxScore, startDate, endDate, pageable);
                } else if (videogames != null) {
                    reviews = reviewService.findByTitleContainingAndVideogameNameInAndCreatedAtBetween(
                            search, videogames, startDate, endDate, pageable);
                } else {
                    reviews = reviewService.findByTitleContainingAndCreatedAtBetween(
                            search, startDate, endDate, pageable);
                }
            } else {
                if (minScore != null && maxScore != null && videogames != null) {
                    reviews = reviewService.findByScoreBetweenAndVideogameNameInAndCreatedAtBetween(
                            minScore, maxScore, videogames, startDate, endDate, pageable);
                } else if (minScore != null && maxScore != null) {
                    reviews = reviewService.findByScoreBetweenAndCreatedAtBetween(
                            minScore, maxScore, startDate, endDate, pageable);
                } else if (videogames != null) {
                    reviews = reviewService.findByVideogameNameInAndCreatedAtBetween(
                            videogames, startDate, endDate, pageable);
                } else {
                    reviews = reviewService.findByCreatedAtBetween(
                            startDate, endDate, pageable);
                }
            }
            List<ReviewDto> reviewDtos = reviews.stream()
                    .map(this::convertToDto)
                    .collect(Collectors.toList());

            Page<ReviewDto> reviewDtoPage = new PageImpl<>(reviewDtos, pageable, reviews.getTotalElements());
            return ResponseEntity.ok(reviewDtoPage);
        } else {
            // timeframe no proporcionado, se pueden usar las mismas opciones sin la restricción de tiempo
            return findAllWithFilters(page, size, search, minScore, maxScore, videogames);
        }
    }

    @GetMapping("/review/{id}")
    public ResponseEntity<ReviewDto> findById(@PathVariable Long id) {
        Review review = reviewService.findById(id).orElseThrow(() -> new ReviewNotFoundException(id));

        return ResponseEntity.ok(convertToDto(review));
    }
    @PostMapping("/review")
    public ResponseEntity<ReviewDto> save(@RequestBody Review review,@RequestHeader("Authorization") String token) {
        Long userId = tokenProvider.getUserIdFromJWT(token);
        UserEntity user = userService.findById(userId).orElse(null);
        final long gameId = review.getVideogame().getId();
        Videogame videogame = videogameService.findById(gameId)
                .orElseThrow(() -> new VideogameNotFoundException(gameId));
        if(review.getScore() > 5 ||review.getScore()<1){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Puntuación no válida");
        }
        if(review.getMessage().length() < 3 || review.getMessage().length() > 10000 ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Mensaje no válido");
        }
        if(review.getTitle().length() < 3 || review.getTitle().length() > 50 ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Título no válido");
        }
        review.setUser(user);
        review.setId(null);
        review.setVideogame(videogame);
        review = reviewService.save(review);

        return ResponseEntity.status(HttpStatus.CREATED).body(convertToDto(review));
    }

    private ReviewDto convertToDto(Review review) {
        return new ReviewDto(
                review.getId(),
                review.getTitle(),
                review.getMessage(),
                review.getScore(),
                review.getCreatedAt(),
                review.getUpdatedAt(),
                userDtoConverter.convertUserEntityToGetUserIdDto(review.getUser()),
                review.getVideogame(),
                review.getLikeCount(),
                review.getFavoriteCount()
        );
    }
    @PutMapping("/review/{id}")
    public ResponseEntity<ReviewDto> update(@PathVariable Long id, @RequestBody Review review,@RequestHeader("Authorization") String token) {
        Long userId = tokenProvider.getUserIdFromJWT(token);
        UserEntity user = userService.findById(userId).orElse(null);
        Optional<Review> reviewCurrent = reviewService.findById(id);
        if (reviewCurrent.isPresent()) {
            if (!reviewCurrent.get().getUser().equals(user)|| review.getUser().getId() != userId) {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuario no autorizado para actualizar la reseña");
            }
            if(review.getScore() > 5 || review.getScore() < 1){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Puntuación no válida");
            }
            if(review.getMessage().length() < 3 || review.getMessage().length() > 10000 ){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Mensaje no válido");
            }
            if(review.getTitle().length() < 3 || review.getTitle().length() > 50 ){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Título no válido");
            }

            review.setId(id);
            review.setCreatedAt(reviewCurrent.get().getCreatedAt());
            Review reviewUpdated = reviewService.modify(review);

            ReviewDto updatedReviewDto = new ReviewDto();
            updatedReviewDto.setId(reviewUpdated.getId());
            updatedReviewDto.setTitle(reviewUpdated.getTitle());
            updatedReviewDto.setMessage(reviewUpdated.getMessage());
            updatedReviewDto.setScore(reviewUpdated.getScore());
            updatedReviewDto.setVideogame(reviewUpdated.getVideogame());
            updatedReviewDto.setCreatedAt(reviewUpdated.getCreatedAt());
            updatedReviewDto.setUpdatedAt(reviewUpdated.getUpdatedAt());
            updatedReviewDto.setUser(userDtoConverter.convertUserEntityToGetUserIdDto(reviewUpdated.getUser()));

            return ResponseEntity.ok(updatedReviewDto);
        } else {
            throw new ReviewNotFoundException(id);
        }
    }
    @DeleteMapping("/review/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id,@RequestHeader("Authorization") String token) {
        Long userId = tokenProvider.getUserIdFromJWT(token);
        Optional<Review> review = reviewService.findById(id);
        if (review.isPresent()) {
            if (review.get().getUser().getId() != userId) {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuario no autorizado para eliminar la reseña");
            }
            reviewService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            throw new ReviewNotFoundException(id);
        }
    }
}
