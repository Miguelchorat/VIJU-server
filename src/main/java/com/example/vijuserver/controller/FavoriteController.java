package com.example.vijuserver.controller;

import com.example.vijuserver.error.UserNotFoundException;
import com.example.vijuserver.security.jwt.JwtProvider;
import com.example.vijuserver.service.FavoriteService;
import com.example.vijuserver.users.model.UserEntity;
import com.example.vijuserver.users.services.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador de Favoritos
 */

@RestController
@RequiredArgsConstructor
public class FavoriteController {
    private final FavoriteService favoriteService;
    private final JwtProvider tokenProvider;
    private final UserEntityService userService;

    /**
     * Comprueba si del usuario que envio la petición con el token dio favorito a una review en concreto
     * @param reviewId
     * @param token
     * @return
     */
    @GetMapping("/review/{reviewId}/favorite")
    public ResponseEntity<Boolean> isReviewFavorite(@PathVariable Long reviewId,@RequestHeader("Authorization") String token) {
        Long userId = tokenProvider.getUserIdFromJWT(token);

        boolean isFavorite = favoriteService.existsByUserIdAndReviewId(userId, reviewId);

        return ResponseEntity.ok(isFavorite);
    }

    /**
     * Añade un favorito a una review y en caso de que ya tuviera un favorito lo elimina del usuario recibido del token de auth
     * @param reviewId
     * @param token
     * @return
     */
    @PostMapping("/favorite/{reviewId}")
    public ResponseEntity<String> toggleFavorite(@PathVariable Long reviewId, @RequestHeader("Authorization") String token) {
        Long userId = tokenProvider.getUserIdFromJWT(token);
        UserEntity user;
        user = userService.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));

        boolean hasLiked = favoriteService.existsByUserIdAndReviewId(userId, reviewId);

        if (hasLiked) {
            favoriteService.removeFavorite(userId, reviewId);
            return ResponseEntity.ok("Favorite removed successfully");
        } else {
            favoriteService.addFavorite(user, reviewId);
            return ResponseEntity.ok("Favorite added successfully");
        }
    }
}
