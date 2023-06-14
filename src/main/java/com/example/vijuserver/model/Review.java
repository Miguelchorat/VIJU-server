package com.example.vijuserver.model;

import com.example.vijuserver.users.model.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
/**
 * Modelo de review
 */
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
    @ManyToOne(fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name="user_id")
    private UserEntity user;
    @ManyToOne(fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name="videogame_id")
    private Videogame videogame;
    /**
     * Tener un contador de los likes
     */
    @Formula("(SELECT COUNT(*) FROM likes l WHERE l.review_id = id)")
    private int likeCount;
    /**
     * Tener un contador de los favoritos
     */
    @Formula("(SELECT COUNT(*) FROM favorites f WHERE f.review_id = id)")
    private int favoriteCount;

    @JsonIgnore
    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    private List<Like> likes;

    @JsonIgnore
    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    private List<Favorite> favorites;

}
