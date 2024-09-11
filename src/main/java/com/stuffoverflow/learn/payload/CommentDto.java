package com.stuffoverflow.learn.payload;

import com.stuffoverflow.learn.entity.Answer;
import com.stuffoverflow.learn.entity.User;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommentDto {
    private int commentId;
    private Date creationTime;
    private String commentContent;
    private int postedByUserId;
    private int commentedOnAnswerId;
}
