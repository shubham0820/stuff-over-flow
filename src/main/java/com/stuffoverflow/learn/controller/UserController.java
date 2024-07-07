package com.stuffoverflow.learn.controller;

import com.stuffoverflow.learn.payload.UserDto;
import com.stuffoverflow.learn.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    //Create
    @PostMapping("/")
    private ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto createdUserDto = this.userService.createUser(userDto);

        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }

    //Read
    @GetMapping("/")
    private ResponseEntity<List<UserDto>> getUsers(){
        List<UserDto> listOfUserDto = this.userService.getUsers();
        return new ResponseEntity<>(listOfUserDto, HttpStatus.FOUND);
    }
    //Update
    private ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto){
        UserDto updatedUser = this.userService.updateUser(userDto);
        return new ResponseEntity<>(updatedUser, HttpStatus.ACCEPTED);
    }

    //Delete
    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteUser(@RequestParam int userId){
        this.userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
