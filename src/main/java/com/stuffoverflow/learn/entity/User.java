package com.stuffoverflow.learn.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, length = 100)
    private String firstName;
    private String lastName;

    @Column(name = "user_name", unique = true, nullable = false, length = 100)
    private String userName;

    @Column(nullable = false, length = 100)
    private String password;
}
