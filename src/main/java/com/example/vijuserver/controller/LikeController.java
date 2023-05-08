package com.example.vijuserver.controller;

import com.example.vijuserver.error.LikeNotFoundException;
import com.example.vijuserver.model.Like;
import com.example.vijuserver.service.LikeService;
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

    @GetMapping("/likes")
    public ResponseEntity<List<Like>> findAll(){
        List<Like> likes = likeService.findAll();
        if(likes.isEmpty()){
            throw new LikeNotFoundException();
        }
        return ResponseEntity.ok(likes);
    }
    @GetMapping("/like/{id}")
    public ResponseEntity<Like> findById(@PathVariable Long id) {
        Like like = likeService.findById(id).orElseThrow(() -> new LikeNotFoundException(id));
        return ResponseEntity.ok(like);
    }
    @PostMapping("/like")
    public ResponseEntity<Like> save(@RequestBody Like like) {
        like.setId(null);
        like = likeService.save(like);
        return ResponseEntity.status(HttpStatus.CREATED).body(like);
    }
    @PutMapping("/like/{id}")
    public ResponseEntity<Like> update(@PathVariable Long id, @RequestBody Like like) {
        Optional<Like> likeCurrent = likeService.findById(id);
        if (likeCurrent.isPresent()) {
            like.setId(id);
            Like likeUpdated = likeService.save(like);
            return new ResponseEntity<>(likeUpdated, HttpStatus.OK);
        } else {
            throw new LikeNotFoundException(id);
        }
    }
    @DeleteMapping("/like/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Like> like = likeService.findById(id);
        if (like.isPresent()) {
            likeService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            throw new LikeNotFoundException(id);
        }
    }
}
