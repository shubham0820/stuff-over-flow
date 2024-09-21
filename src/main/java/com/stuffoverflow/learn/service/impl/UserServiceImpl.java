package com.stuffoverflow.learn.service.impl;

import com.stuffoverflow.learn.entity.Role;
import com.stuffoverflow.learn.entity.User;
import com.stuffoverflow.learn.payload.UserDto;
import com.stuffoverflow.learn.repository.RoleRepo;
import com.stuffoverflow.learn.repository.UserRepo;
import com.stuffoverflow.learn.security.service.JWTService;
import com.stuffoverflow.learn.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    @Override
    public UserDto registerNewUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto, User.class);
        user.setPassword(new BCryptPasswordEncoder(12).encode(user.getPassword()));
        Role role = this.roleRepo.findById(501).orElseThrow(()->new RuntimeException("501 roleid not found"));
        user.setRoleSet(Set.of(role));

        User createdUser = this.userRepo.save(user);
        return this.modelMapper.map(createdUser, UserDto.class);
    }

    public String verifyUser(UserDto userDto){
        Authentication authenticate = this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDto.getUserName(),userDto.getPassword()));
        if(authenticate.isAuthenticated()){
            return jwtService.generateToken(userDto.getUserName());
        }
        return "failed to authenticate the user";
    }
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
    public UserDto updateUser(UserDto userDto, int userId) {
        User userToUpdate = this.userRepo.findById(userId).orElseThrow(()->new RuntimeException("user not found"));

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
