package com.example.vijuserver.model;

import com.example.vijuserver.users.model.UserEntity;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

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
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "review_id")
    private Review review;
    private LocalDateTime created_at;
}
