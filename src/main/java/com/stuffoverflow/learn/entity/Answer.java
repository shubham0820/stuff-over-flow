package com.stuffoverflow.learn.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int answerId;

    private String content;

    @ManyToOne
    private Question question;

    @ManyToOne
    private User user;

    private Date createdTimestamp;

    @OneToMany(mappedBy = "answer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> listOfComments;
}
