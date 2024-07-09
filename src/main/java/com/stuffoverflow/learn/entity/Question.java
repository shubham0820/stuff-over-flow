package com.stuffoverflow.learn.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;

//  Timedata reference:  https://www.youtube.com/watch?v=a4FELDK19Ak
    private Date createdTimestamp;
    @ManyToOne
    private User user;

//    @TODO: add QuestionLikes & QuestionsDislikes attributes
}
