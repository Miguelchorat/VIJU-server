package com.example.vijuserver.service;

import com.example.vijuserver.model.Videogame;
import com.example.vijuserver.repository.VideogameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
/**
 * Servicio de videojuegos conecta las peticiones del controlador con el repositorio
 */
@Service
public class VideogameService {
    @Autowired
    private VideogameRepository videogameRepository;

    /**
     * Lista los videojuegos sin ningun tipo de filtro
     * @return
     */
    public List<Videogame> findAll(){
        return videogameRepository.findAll();
    }

    /**
     * Lista los videojuegos filtrando por el parametro name en el título de videojuegos
     * @param name
     * @return
     */
    public List<Videogame> findByName(String name) {
        return videogameRepository.findByNameContainingIgnoreCase(name);
    }

    /**
     * Busca un videojuego por su id
     * @param id
     * @return
     */
    public Optional<Videogame> findById(Long id){
        return videogameRepository.findById(id);
    }

    /**
     * Guarda un videojuego
     * @param videogame
     * @return
     */
    public Videogame save(Videogame videogame){
        videogame.setCreated_at(LocalDateTime.now());
        videogame.setUpdated_at(LocalDateTime.now());
        return videogameRepository.save(videogame);
    }

    /**
     * Modifica un videojuego
     * @param videogame
     * @return
     */
    public Videogame modify(Videogame videogame){
        videogame.setUpdated_at(LocalDateTime.now());
        return videogameRepository.save(videogame);
    }

    /**
     * Elimina un videojuego
     * @param id
     */
    public void deleteById(Long id){
        videogameRepository.deleteById(id);
    }
}
