package com.stuffoverflow.learn.payload;

import com.stuffoverflow.learn.entity.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {

    private int userId;

    @NotNull
    @NotBlank(message = "first name can't be empty")
    @Size(min = 7,max = 50)
    private String firstName;
    private String lastName;

    @NotNull
    @NotBlank(message = "user name can't be empty")
    @Size(min = 8,max = 10)
    private String userName;

    @NotNull
    @NotBlank(message = "password can't be empty")
    @Size(min = 8,max = 30)
    private String password;

    private Set<Role> roleSet;
}
