package com.stuffoverflow.learn.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @Column(nullable = false, length = 100)
    private String firstName;
    private String lastName;

    @Column(name = "user_name", unique = true, nullable = false, length = 100)
    private String userName;

    @Column(nullable = false, length = 100)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Question> listOfQuestions = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Answer> listOfAnswers = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
            @JoinTable(name="user_roles",
            joinColumns = {
                    @JoinColumn(name = "user_id", referencedColumnName = "userId")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "roleId")
            })
    private Set<Role> roleSet;

    @OneToMany(mappedBy = "postedByUser", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Comment> listOfComments;
}
