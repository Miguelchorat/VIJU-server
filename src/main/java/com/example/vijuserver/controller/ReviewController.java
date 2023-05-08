package com.example.vijuserver.controller;

import com.example.vijuserver.error.ReviewNotFoundException;
import com.example.vijuserver.model.Review;
import com.example.vijuserver.service.ReviewService;
import lombok.RequiredArgsConstructor;
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
        List<Review> users = reviewService.findAll();
        if(users.isEmpty()){
            throw new ReviewNotFoundException();
        }
        return ResponseEntity.ok(users);
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
            review.setCreated_at(reviewCurrent.get().getCreated_at());
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
