package com.stuffoverflow.learn.service;

import com.stuffoverflow.learn.entity.User;
import com.stuffoverflow.learn.repository.UserRepo;
import com.stuffoverflow.learn.utils.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepo.findByUserName(username);
        return new CustomUserDetails(user);
    }
}
