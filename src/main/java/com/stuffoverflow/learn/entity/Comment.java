package com.stuffoverflow.learn.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentId;

    private Date creationTime;

    private String commentContent;

    @ManyToOne
    private User postedByUser;

    @ManyToOne
    private Answer commentedOnAnswer;


}
