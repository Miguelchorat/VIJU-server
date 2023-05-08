package com.example.vijuserver.controller;

import com.example.vijuserver.error.VideogameNotFoundException;
import com.example.vijuserver.model.Videogame;
import com.example.vijuserver.service.VideogameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class VideogameController {
    private final VideogameService videogameService;

    @GetMapping("/videogames")
    public ResponseEntity<List<Videogame>> findAll(){
        List<Videogame> videogames = videogameService.findAll();
        if(videogames.isEmpty()){
            throw new VideogameNotFoundException();
        }
        return ResponseEntity.ok(videogames);
    }
    @GetMapping("/videogame/{id}")
    public ResponseEntity<Videogame> findById(@PathVariable Long id) {
        Videogame videogame = videogameService.findById(id).orElseThrow(() -> new VideogameNotFoundException(id));
        return ResponseEntity.ok(videogame);
    }
    @PostMapping("/videogame")
    public ResponseEntity<Videogame> save(@RequestBody Videogame videogame) {
        videogame.setId(null);
        videogame = videogameService.save(videogame);
        return ResponseEntity.status(HttpStatus.CREATED).body(videogame);
    }
    @PutMapping("/videogame/{id}")
    public ResponseEntity<Videogame> update(@PathVariable Long id, @RequestBody Videogame videogame) {
        Optional<Videogame> videogameCurrent = videogameService.findById(id);
        if (videogameCurrent.isPresent()) {
            videogame.setId(id);
            videogame.setCreated_at(videogameCurrent.get().getCreated_at());
            Videogame videogameUpdated = videogameService.modify(videogame);
            return new ResponseEntity<>(videogameUpdated, HttpStatus.OK);
        } else {
            throw new VideogameNotFoundException(id);
        }
    }
    @DeleteMapping("/videogame/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Videogame> videogame = videogameService.findById(id);
        if (videogame.isPresent()) {
            videogameService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            throw new VideogameNotFoundException(id);
        }
    }
}
