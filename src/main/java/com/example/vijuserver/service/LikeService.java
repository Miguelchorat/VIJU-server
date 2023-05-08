package com.example.vijuserver.service;

import com.example.vijuserver.model.Like;
import com.example.vijuserver.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LikeService {
    @Autowired
    private LikeRepository likeRepository;

    public List<Like> findAll(){
        return likeRepository.findAll();
    }
    public Optional<Like> findById(Long id){
        return likeRepository.findById(id);
    }
    public Like save(Like like){
        like.setCreated_at(LocalDateTime.now());
        return likeRepository.save(like);
    }
    public void deleteById(Long id){
        likeRepository.deleteById(id);
    }
}
