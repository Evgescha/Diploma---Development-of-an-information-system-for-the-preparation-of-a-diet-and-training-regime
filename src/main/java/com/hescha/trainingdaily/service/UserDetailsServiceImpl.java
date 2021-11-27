package com.hescha.trainingdaily.service;

import java.util.ArrayList;
import java.util.List;

import com.hescha.trainingdaily.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserServiceImpl userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userService.findByUsername(username);
        UserDetails userDetails = null;
        List<GrantedAuthority> grantList;
        if (user == null) {
            throw new UsernameNotFoundException("Пользователь " + username + " не был найден в базе");
        }

        if (user.getRole() != null) {
            grantList = new ArrayList<>();
            String roleAsString = user.getRole().getName();
            GrantedAuthority authority = new SimpleGrantedAuthority(roleAsString);
            grantList.add(authority);

            userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                    grantList);
        }
        return userDetails;
    }
}
