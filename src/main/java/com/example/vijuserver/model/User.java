package com.example.vijuserver.model;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String email;
    private String password;
    private String avatar;
    private LocalDateTime date;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

}
