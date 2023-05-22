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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;
    private final JwtProvider tokenProvider;
    private final UserDtoConverter userDtoConverter;
    private final UserEntityService userService;
    private final VideogameService videogameService;

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> findAll(){
        List<Review> reviews = reviewService.findAll();
        if(reviews.isEmpty()){
            throw new ReviewNotFoundException();
        }
        return ResponseEntity.ok(reviews);
    }
    @GetMapping("/reviewsFilter")
    public ResponseEntity<Page<Review>> findAllWithFilters(@RequestParam(defaultValue = "0") int page,
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
        return ResponseEntity.ok(reviews);
    }
    @GetMapping("/review/{id}")
    public ResponseEntity<Review> findById(@PathVariable Long id) {
        Review review = reviewService.findById(id).orElseThrow(() -> new ReviewNotFoundException(id));
        return ResponseEntity.ok(review);
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

        ReviewDto savedReviewDto = new ReviewDto();
        savedReviewDto.setId(review.getId());
        savedReviewDto.setTitle(review.getTitle());
        savedReviewDto.setMessage(review.getMessage());
        savedReviewDto.setScore(review.getScore());
        savedReviewDto.setVideogame(review.getVideogame());
        savedReviewDto.setCreatedAt(review.getCreatedAt());
        savedReviewDto.setUpdatedAt(review.getUpdatedAt());
        savedReviewDto.setUser(userDtoConverter.convertUserEntityToGetUserIdDto(review.getUser()));

        return ResponseEntity.status(HttpStatus.CREATED).body(savedReviewDto);
    }
    @PutMapping("/review/{id}")
    public ResponseEntity<Review> update(@PathVariable Long id, @RequestBody Review review) {
        Optional<Review> reviewCurrent = reviewService.findById(id);
        if (reviewCurrent.isPresent()) {
            review.setId(id);
            review.setCreatedAt(reviewCurrent.get().getCreatedAt());
            Review reviewUpdated = reviewService.modify(review);
            return new ResponseEntity<>(reviewUpdated, HttpStatus.OK);
        } else {
            throw new ReviewNotFoundException(id);
        }
    }
    @DeleteMapping("/review/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Review> review = reviewService.findById(id);
        if (review.isPresent()) {
            reviewService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            throw new ReviewNotFoundException(id);
        }
    }
}
