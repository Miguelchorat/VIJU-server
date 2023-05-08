package com.example.vijuserver.controller;

import com.example.vijuserver.error.PlatformNotFoundException;
import com.example.vijuserver.error.UserNotFoundException;
import com.example.vijuserver.model.Platform;
import com.example.vijuserver.service.PlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PlatformController {
    private final PlatformService platformService;

    @GetMapping("/platforms")
    public ResponseEntity<List<Platform>> findAll(){
        List<Platform> platforms = platformService.findAll();
        if(platforms.isEmpty()){
            throw new PlatformNotFoundException();
        }
        return ResponseEntity.ok(platforms);
    }
    @GetMapping("/platform/{id}")
    public ResponseEntity<Platform> findById(@PathVariable Long id) {
        Platform platform = platformService.findById(id).orElseThrow(() -> new PlatformNotFoundException(id));
        return ResponseEntity.ok(platform);
    }
    @PostMapping("/platform")
    public ResponseEntity<Platform> save(@RequestBody Platform platform) {
        platform.setId(null);
        platform = platformService.save(platform);
        return ResponseEntity.status(HttpStatus.CREATED).body(platform);
    }
    @PutMapping("/platform/{id}")
    public ResponseEntity<Platform> update(@PathVariable Long id, @RequestBody Platform platform) {
        Optional<Platform> platformCurrent = platformService.findById(id);
        if (platformCurrent.isPresent()) {
            platform.setId(id);
            platform.setCreated_at(platformCurrent.get().getCreated_at());
            Platform platformUpdated = platformService.modify(platform);
            return new ResponseEntity<>(platformUpdated, HttpStatus.OK);
        } else {
            throw new PlatformNotFoundException(id);
        }
    }
    @DeleteMapping("/platform/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Platform> platform = platformService.findById(id);
        if (platform.isPresent()) {
            platformService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            throw new PlatformNotFoundException(id);
        }
    }
}
