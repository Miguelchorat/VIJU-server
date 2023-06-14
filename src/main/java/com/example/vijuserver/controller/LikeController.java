package com.example.vijuserver.controller;

import com.example.vijuserver.error.UserNotFoundException;
import com.example.vijuserver.security.jwt.JwtProvider;
import com.example.vijuserver.service.LikeService;
import com.example.vijuserver.users.model.UserEntity;
import com.example.vijuserver.users.services.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador de Likes
 */
@RestController
@RequiredArgsConstructor
public class LikeController {
    private final LikeService likeService;
    private final JwtProvider tokenProvider;
    private final UserEntityService userService;

    /**
     * Comprueba si del usuario que envio la petición con el token dio like a una review en concreto
     * @param reviewId
     * @param token
     * @return
     */
    @GetMapping("/review/{reviewId}/liked")
    public ResponseEntity<Boolean> isReviewLiked(@PathVariable Long reviewId,@RequestHeader("Authorization") String token) {
        Long userId = tokenProvider.getUserIdFromJWT(token);

        boolean isLiked = likeService.existsByUserIdAndReviewId(userId, reviewId);

        return ResponseEntity.ok(isLiked);
    }

    /**
     * Añade un like a una review y en caso de que ya tuviera un like lo elimina del usuario recibido del token de auth
     * @param reviewId
     * @param token
     * @return
     */
    @PostMapping("/like/{reviewId}")
    public ResponseEntity<String> toggleLike(@PathVariable Long reviewId, @RequestHeader("Authorization") String token) {
        Long userId = tokenProvider.getUserIdFromJWT(token);
        UserEntity user = userService.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));

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
