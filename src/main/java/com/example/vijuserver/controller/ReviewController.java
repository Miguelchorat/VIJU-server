package com.example.vijuserver.controller;

import com.example.vijuserver.error.ReviewNotFoundException;
import com.example.vijuserver.model.Review;
import com.example.vijuserver.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

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
    public ResponseEntity<Review> save(@RequestBody Review review) {
        review.setId(null);
        review = reviewService.save(review);
        return ResponseEntity.status(HttpStatus.CREATED).body(review);
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
