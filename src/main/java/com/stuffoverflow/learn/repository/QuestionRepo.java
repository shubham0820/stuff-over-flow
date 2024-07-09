package com.stuffoverflow.learn.repository;

import com.stuffoverflow.learn.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question, Integer> {
}
