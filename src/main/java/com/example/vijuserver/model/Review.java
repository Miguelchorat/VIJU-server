package com.example.vijuserver.model;

import com.example.vijuserver.users.model.UserEntity;
import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Review {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String message;
    private int score;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name="user_id")
    private UserEntity user;
    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name="videogame_id")
    private Videogame videogame;
}
