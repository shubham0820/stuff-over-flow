package com.stuffoverflow.learn.service;

import com.stuffoverflow.learn.payload.UserDto;

import java.util.List;

public interface UserService {
    UserDto registerNewUser(UserDto userDto);

    String verifyUser(UserDto userDto);
    UserDto createUser(UserDto userDto);
    List<UserDto> getUsers();
    UserDto updateUser(UserDto userDto, int userId);
    void deleteUser(int userId);
}
