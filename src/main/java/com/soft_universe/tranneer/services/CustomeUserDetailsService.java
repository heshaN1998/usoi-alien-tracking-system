package com.soft_universe.tranneer.services;

import com.soft_universe.tranneer.entities.User;
import com.soft_universe.tranneer.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomeUserDetailsService implements UserDetailsService {
private final UserRepository userRepository;
public CustomeUserDetailsService(UserRepository userRepository){
    this.userRepository=userRepository;
}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findUserName(username).orElseThrow(()->new UsernameNotFoundException("User Not Found"));
        return org.springframework.security.core.userdetails.User
                .builder()
                .username(user.getUserName())
                .password(user.getPassword())
                .roles(user.getRole().name())
                .build();
    }
}
