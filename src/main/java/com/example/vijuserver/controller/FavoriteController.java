package com.example.vijuserver.controller;

import com.example.vijuserver.error.FavoriteNotFoundException;
import com.example.vijuserver.model.Favorite;
import com.example.vijuserver.service.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class FavoriteController {
    private final FavoriteService favoriteService;

    @GetMapping("/favorites")
    public ResponseEntity<List<Favorite>> findAll(){
        List<Favorite> favorites = favoriteService.findAll();
        if(favorites.isEmpty()){
            throw new FavoriteNotFoundException();
        }
        return ResponseEntity.ok(favorites);
    }
    @GetMapping("/favorite/{id}")
    public ResponseEntity<Favorite> findById(@PathVariable Long id) {
        Favorite favorite = favoriteService.findById(id).orElseThrow(() -> new FavoriteNotFoundException(id));
        return ResponseEntity.ok(favorite);
    }
    @PostMapping("/favorite")
    public ResponseEntity<Favorite> save(@RequestBody Favorite favorite) {
        favorite.setId(null);
        favorite = favoriteService.save(favorite);
        return ResponseEntity.status(HttpStatus.CREATED).body(favorite);
    }
    @PutMapping("/favorite/{id}")
    public ResponseEntity<Favorite> update(@PathVariable Long id, @RequestBody Favorite favorite) {
        Optional<Favorite> favoriteCurrent = favoriteService.findById(id);
        if (favoriteCurrent.isPresent()) {
            favorite.setId(id);
            Favorite favoriteUpdated = favoriteService.save(favorite);
            return new ResponseEntity<>(favoriteUpdated, HttpStatus.OK);
        } else {
            throw new FavoriteNotFoundException(id);
        }
    }
    @DeleteMapping("/favorite/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Favorite> favorite = favoriteService.findById(id);
        if (favorite.isPresent()) {
            favoriteService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            throw new FavoriteNotFoundException(id);
        }
    }
}
