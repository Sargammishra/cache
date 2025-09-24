package com.adcb.cache.service;



import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class CacheService {

    @Cacheable(value = "objects", key = "#key")
    public String getValue(String key) {
        System.out.println("Fetching from DB for ID: " + key);
        return "User-" + key;
    }

    // Example: update user (cache refresh)
    @CachePut(value = "objects", key = "#key")
    public String updateUser(String key, String newValue) {
        System.out.println("Updating DB for key: " + key);
        return newValue;
    }

    // Example: delete user from cache
    @CacheEvict(value = "objects", key = "#key")
    public void deleteUser(String key) {
        System.out.println("Deleting from DB and Cache for key: " + key);
    }
}
