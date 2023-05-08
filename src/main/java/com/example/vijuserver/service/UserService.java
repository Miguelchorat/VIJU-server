package com.example.vijuserver.service;

import com.example.vijuserver.model.User;
import com.example.vijuserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }
    public User save(User user){
        user.setCreated_at(LocalDateTime.now());
        user.setUpdated_at(LocalDateTime.now());
        return userRepository.save(user);
    }
    public User modify(User user){
        user.setUpdated_at(LocalDateTime.now());
        return userRepository.save(user);
    }
    public void deleteById(Long id){
        userRepository.deleteById(id);
    }
}
