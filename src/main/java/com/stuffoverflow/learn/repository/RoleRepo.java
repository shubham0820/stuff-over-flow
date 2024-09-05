package com.stuffoverflow.learn.repository;

import com.stuffoverflow.learn.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {
}
