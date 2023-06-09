package com.example.vijuserver.model;

import com.example.vijuserver.users.model.UserEntity;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Modelo de favorito
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "favorites")
public class Favorite {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    private Review review;
    private LocalDateTime created_at;
}
