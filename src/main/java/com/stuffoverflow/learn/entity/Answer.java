package com.stuffoverflow.learn.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String content;

    @ManyToOne
    private Question question;

    @ManyToOne
    private User user;

    private Date createdTimestamp;
}
