package com.example.vijuserver.users.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserStatsDto {
    private int likeCount;
    private int favoriteCount;
    private int reviewCount;
}
