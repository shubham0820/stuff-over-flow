package com.stuffoverflow.learn.repository;

import com.stuffoverflow.learn.entity.Answer;
import com.stuffoverflow.learn.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    Answer findByUser(User user);
}
