package com.example.vijuserver.service;

import com.example.vijuserver.model.Platform;
import com.example.vijuserver.repository.PlatformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PlatformService {
    @Autowired
    private PlatformRepository platformRepository;

    public List<Platform> findAll(){
        return platformRepository.findAll();
    }
    public Optional<Platform> findById(Long id){
        return platformRepository.findById(id);
    }
    public Platform save(Platform platform){
        platform.setCreated_at(LocalDateTime.now());
        platform.setUpdated_at(LocalDateTime.now());
        return platformRepository.save(platform);
    }
    public Platform modify(Platform platform){
        platform.setUpdated_at(LocalDateTime.now());
        return platformRepository.save(platform);
    }
    public void deleteById(Long id){
        platformRepository.deleteById(id);
    }
}
