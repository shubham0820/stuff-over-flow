package com.stuffoverflow.learn.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.Date;
import java.util.List;

public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String description;

//  Timedata reference:  https://www.youtube.com/watch?v=a4FELDK19Ak
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTimestamp;

    @ManyToOne
    User ownedByUser;
    List<User> likedByUsers;
    List<User> dislikedByUsers;
}
