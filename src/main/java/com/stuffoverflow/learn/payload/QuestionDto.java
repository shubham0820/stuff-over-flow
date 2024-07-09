package com.stuffoverflow.learn.payload;

import com.stuffoverflow.learn.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class QuestionDto {
    private Integer id;
    private String title;
    private String description;
    private Date createdTimestamp;
    private UserDto user;
//    private List<UserDto> likedByUsers;
//    private List<UserDto> dislikedByUsers;
}
