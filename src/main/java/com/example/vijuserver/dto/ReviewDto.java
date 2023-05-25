package com.example.vijuserver.dto;

import com.example.vijuserver.model.Videogame;
import com.example.vijuserver.users.dto.GetUserDto;
import com.example.vijuserver.users.dto.GetUserIdDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewDto {
    private Long id;
    private String title;
    private String message;
    private int score;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private GetUserIdDto user; // DTO de usuario
    private Videogame videogame;
    private int likesCount;
    private int favoritesCount;
}
