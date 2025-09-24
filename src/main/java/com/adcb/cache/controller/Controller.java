package com.adcb.cache.controller;

import com.adcb.cache.service.CacheService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cache")
public class Controller {

    private final CacheService cacheService;

    public Controller(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @PostMapping("/{key}")
    public String save(@PathVariable String key, @RequestBody String value) {
        cacheService.updateUser(key, value);
        return "Saved " + key;
    }

    @GetMapping("/{key}")
    public Object get(@PathVariable String key) {
        return cacheService.getValue(key);
    }

    @DeleteMapping("/{key}")
    public void deleteUser(@PathVariable String key) {
         cacheService.deleteUser(key);
    }


}
