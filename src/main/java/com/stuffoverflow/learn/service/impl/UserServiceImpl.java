package com.stuffoverflow.learn.service.impl;

import com.stuffoverflow.learn.entity.User;
import com.stuffoverflow.learn.payload.UserDto;
import com.stuffoverflow.learn.repository.UserRepo;
import com.stuffoverflow.learn.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto, User.class);
        User createdUser = this.userRepo.save(user);
        return this.modelMapper.map(createdUser, UserDto.class);
    }

    @Override
    public List<UserDto> getUsers() {
        List<User> userList = this.userRepo.findAll();
        List<UserDto> userDtoList = userList.stream().map(user -> this.modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
        return userDtoList;
    }
}
