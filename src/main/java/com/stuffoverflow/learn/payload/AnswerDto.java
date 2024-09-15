package com.stuffoverflow.learn.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stuffoverflow.learn.entity.Comment;
import com.stuffoverflow.learn.entity.Question;
import com.stuffoverflow.learn.entity.User;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AnswerDto {
    private int answerId;
    private String content;
    private Date createdTimestamp;
    private int questionId;
    private int userId;
//    private List<Comment> listOfComments;
}
