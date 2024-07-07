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

    @Override
    public UserDto updateUser(UserDto userDto) {
        User userToUpdate = this.userRepo.findById(userDto.getId()).orElseThrow(()->new RuntimeException("user not found"));

        userToUpdate.setUserName(userDto.getUserName());
        userToUpdate.setPassword(userDto.getPassword());
        userToUpdate.setFirstName(userDto.getFirstName());
        userToUpdate.setLastName(userDto.getLastName());
        User updatedUser = this.userRepo.save(userToUpdate);

        return this.modelMapper.map(updatedUser, UserDto.class);
    }

    @Override
    public void deleteUser(int userId) {
        User userToDelete = this.userRepo.findById(userId).orElseThrow(()->new RuntimeException("user not found"));
        this.userRepo.delete(userToDelete);
    }
}
