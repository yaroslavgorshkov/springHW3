package com.example.springhw3security.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users_security_hw")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    public UserRole role;
}
