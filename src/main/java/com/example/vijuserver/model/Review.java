package com.example.vijuserver.model;

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
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name="user_id")
    private User user;
    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name="videogame_id")
    private Videogame videogame;
}
