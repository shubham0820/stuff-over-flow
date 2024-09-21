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

    //register new user
    @PostMapping("/register")
    public ResponseEntity<UserDto> registerNewUser(@RequestBody UserDto userDto){

        UserDto createdUserDto = this.userService.registerNewUser(userDto);

        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.verifyUser(userDto), HttpStatus.FORBIDDEN);
    }

    //Create
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto createdUserDto = this.userService.createUser(userDto);

        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }

    //Read
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getUsers(){
        List<UserDto> listOfUserDto = this.userService.getUsers();
        return new ResponseEntity<>(listOfUserDto, HttpStatus.FOUND);
    }
    //Update
    @PutMapping("/userId={userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,
                                               @PathVariable("userId") int userId){
        UserDto updatedUser = this.userService.updateUser(userDto, userId);
        return new ResponseEntity<>(updatedUser, HttpStatus.ACCEPTED);
    }

    //Delete
    @DeleteMapping("/userId={id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int userId){
        this.userService.deleteUser(userId);
        return new ResponseEntity<>("user has been deleted", HttpStatus.OK);
    }
}
