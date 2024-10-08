package com.stuffoverflow.learn.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionId;
    private String title;
    private String description;

//  Timedata reference:  https://www.youtube.com/watch?v=a4FELDK19Ak
    private Date createdTimestamp;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Answer> listOfAnswers;

//    @TODO: add QuestionLikes & QuestionsDislikes attributes
}
