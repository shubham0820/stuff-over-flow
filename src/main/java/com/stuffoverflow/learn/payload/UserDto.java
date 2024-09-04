package com.stuffoverflow.learn.payload;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

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
}
