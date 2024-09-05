package com.stuffoverflow.learn.payload;

import com.stuffoverflow.learn.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoleDto {
    private int roleId;
    private int role;

    private List<User> listOfUsers;
}
