package com.example.vijuserver.cache;

import com.example.vijuserver.users.model.UserEntity;

public interface UserCache {
    void putUser(Long userId, UserEntity user);
    UserEntity getUser(Long userId);
    void removeUser(Long userId);
}