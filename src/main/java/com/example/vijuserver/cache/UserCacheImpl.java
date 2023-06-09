package com.example.vijuserver.cache;

import com.example.vijuserver.users.model.UserEntity;

import java.util.HashMap;
import java.util.Map;

public class UserCacheImpl implements UserCache {
    private final Map<Long, UserEntity> cache;

    public UserCacheImpl() {
        cache = new HashMap<>();
    }

    @Override
    public void putUser(Long userId, UserEntity user) {
        cache.put(userId, user);
    }

    @Override
    public UserEntity getUser(Long userId) {
        return cache.get(userId);
    }

    @Override
    public void removeUser(Long userId) {
        cache.remove(userId);
    }
}
