package com.example.vijuserver.service;

import com.example.vijuserver.model.Favorite;
import com.example.vijuserver.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FavoriteService {
    @Autowired
    private FavoriteRepository favoriteRepository;

    public List<Favorite> findAll(){
        return favoriteRepository.findAll();
    }
    public Optional<Favorite> findById(Long id){
        return favoriteRepository.findById(id);
    }
    public Favorite save(Favorite favorite){
        favorite.setCreated_at(LocalDateTime.now());
        return favoriteRepository.save(favorite);
    }
    public void deleteById(Long id){
        favoriteRepository.deleteById(id);
    }
}
