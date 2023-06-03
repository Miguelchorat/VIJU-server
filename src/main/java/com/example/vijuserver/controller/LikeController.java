package com.example.vijuserver.controller;

import com.example.vijuserver.error.LikeNotFoundException;
import com.example.vijuserver.error.UserNotFoundException;
import com.example.vijuserver.model.Like;
import com.example.vijuserver.security.jwt.JwtProvider;
import com.example.vijuserver.service.LikeService;
import com.example.vijuserver.users.model.UserEntity;
import com.example.vijuserver.users.services.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequiredArgsConstructor
public class LikeController {
    private final LikeService likeService;
    private final JwtProvider tokenProvider;
    private final UserEntityService userService;

    @GetMapping("/review/{reviewId}/liked")
    public ResponseEntity<Boolean> isReviewLiked(@PathVariable Long reviewId,@RequestHeader("Authorization") String token) {
        Long userId = tokenProvider.getUserIdFromJWT(token);
        UserEntity user = userService.findById(userId).orElseThrow(()-> new UserNotFoundException(userId));

        boolean isLiked = likeService.existsByUserIdAndReviewId(user.getId(), reviewId);

        return ResponseEntity.ok(isLiked);
    }

    @PostMapping("/like/{reviewId}")
    public ResponseEntity<String> toggleLike(@PathVariable Long reviewId, @RequestHeader("Authorization") String token) {
        Long userId = tokenProvider.getUserIdFromJWT(token);
        UserEntity user = userService.findById(userId).orElseThrow(()-> new UserNotFoundException(userId));

        boolean hasLiked = likeService.existsByUserIdAndReviewId(userId, reviewId);

        if (hasLiked) {
            likeService.removeLike(userId, reviewId);
            return ResponseEntity.ok("Like removed successfully");
        } else {
            likeService.addLike(user, reviewId);
            return ResponseEntity.ok("Like added successfully");
        }
    }
}
