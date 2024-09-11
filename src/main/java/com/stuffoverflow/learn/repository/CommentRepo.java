package com.stuffoverflow.learn.repository;

import com.stuffoverflow.learn.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
}
