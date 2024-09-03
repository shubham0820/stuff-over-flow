package com.stuffoverflow.learn.payload;

import com.stuffoverflow.learn.entity.Question;
import com.stuffoverflow.learn.entity.User;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AnswerDto {
    private int id;
    private String content;
    private Date createdTimestamp;
    private int questionId;
    private int userId;

}
