package com.stuffoverflow.learn.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Data
public class Role {
    @Id
    private int roleId;
    private String role;
//    @ManyToMany(mappedBy = "lisOfRoles", fetch = FetchType.LAZY)
//    private Set<User> listOfUsers;
}
