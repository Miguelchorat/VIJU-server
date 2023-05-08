package com.example.vijuserver.service;

import com.example.vijuserver.model.Videogame;
import com.example.vijuserver.repository.VideogameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VideogameService {
    @Autowired
    private VideogameRepository videogameRepository;

    public List<Videogame> findAll(){
        return videogameRepository.findAll();
    }
    public Optional<Videogame> findById(Long id){
        return videogameRepository.findById(id);
    }
    public Videogame save(Videogame videogame){
        videogame.setCreated_at(LocalDateTime.now());
        videogame.setUpdated_at(LocalDateTime.now());
        return videogameRepository.save(videogame);
    }
    public Videogame modify(Videogame videogame){
        videogame.setUpdated_at(LocalDateTime.now());
        return videogameRepository.save(videogame);
    }
    public void deleteById(Long id){
        videogameRepository.deleteById(id);
    }
}
