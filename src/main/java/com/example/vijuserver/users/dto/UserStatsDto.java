package com.example.vijuserver.users.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
/**
 * Modelo que contiene los datos de las estadisticas de un usuario
 */
public class UserStatsDto {
    private int likeCount;
    private int favoriteCount;
    private int reviewCount;
}
