package com.example.vijuserver.model;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Videogame {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String image;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
