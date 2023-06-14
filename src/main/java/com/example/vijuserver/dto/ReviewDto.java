package com.example.vijuserver.dto;

import com.example.vijuserver.model.Videogame;
import com.example.vijuserver.users.dto.GetUserIdDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Modifica el modelo de Review para solo mandar unos datos en concretos
 */
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
