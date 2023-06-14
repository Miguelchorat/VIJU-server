package com.example.vijuserver.controller;

import com.example.vijuserver.error.VideogameNotFoundException;
import com.example.vijuserver.model.Videogame;
import com.example.vijuserver.service.VideogameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Controlador de videojuegos
 */
@RestController
@RequiredArgsConstructor
public class VideogameController {
    private final VideogameService videogameService;

    /**
     * Recibe una lista de los videojuegos ya sea por un filtro de búsqueda de su título o sin el
     * @param search
     * @return
     */
    @GetMapping("/videogames")
    public ResponseEntity<List<Videogame>> findAll(@RequestParam(required = false) String search){
        List<Videogame> videogames = null;
        if (search == null) {
            videogames = videogameService.findAll();
        } else {
            videogames = videogameService.findByName(search);
        }
        Collections.sort(videogames, Comparator.comparing(Videogame::getName));
        return ResponseEntity.ok(videogames);
    }

    /**
     * Hace la busqueda de un videojuego por una id en concreto
     * @param id
     * @return
     */
    @GetMapping("/videogame/{id}")
    public ResponseEntity<Videogame> findById(@PathVariable Long id) {
        Videogame videogame = videogameService.findById(id).orElseThrow(() -> new VideogameNotFoundException(id));
        return ResponseEntity.ok(videogame);
    }

    /**
     * Guarda un videojuego
     * @param videogame
     * @return
     */
    @PostMapping("/videogame")
    public ResponseEntity<Videogame> save(@RequestBody Videogame videogame) {
        videogame.setId(null);
        videogame = videogameService.save(videogame);
        return ResponseEntity.status(HttpStatus.CREATED).body(videogame);
    }

    /**
     * Modifica un videojuego
     * @param id
     * @param videogame
     * @return
     */
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

    /**
     * Elimina un videojuego
     * @param id
     * @return
     */
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
