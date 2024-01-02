package com.book.security;

import com.book.model.User;
import com.book.service.UService;
import com.book.util.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UService uService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= uService.findByUserName(username).orElseThrow(()->new UsernameNotFoundException(username));
        Set<GrantedAuthority> authoritySet = Set.of(SecurityUtils.convertToAuthority(user.getRole().name()));


        return CustomUserDetails.builder()
                .user(user).userName(user.getUserName())
                .password(user.getPassword())
                .authoritySet(authoritySet)
                .build();
    }



}
