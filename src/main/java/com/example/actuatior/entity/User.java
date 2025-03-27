package com.example.actuatior.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, nullable = false)
    private String username;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Article> articles;
}
