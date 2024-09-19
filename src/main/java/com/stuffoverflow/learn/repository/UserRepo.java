package com.stuffoverflow.learn.repository;

import com.stuffoverflow.learn.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUserName(String userName);
}
