package com.book.security.authController;


import com.book.model.Role;
import com.book.model.User;
import com.book.repo.UserRepo;
import com.book.security.authModel.AuthRequest;
import com.book.security.authModel.AuthResponse;
import com.book.security.authModel.SignUp;
import com.book.security.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepo userRepo;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthResponse register(SignUp request) {
        User user= User.builder()
                .name(request.getUserName())
                .userName(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)

                .build();
        userRepo.save(user);

        String jwtToken =jwtService.generateToken(user);

        return AuthResponse.builder().token(jwtToken).build();
    }

    public AuthResponse authenticate(AuthRequest request) {

        System.err.println(request.getEmail());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),

                        request.getPassword()
                )

        );

        var user=userRepo.findByUserName(request.getEmail()).orElseThrow(()->new UsernameNotFoundException("User not found"));
        String jwtToken =jwtService.generateToken(user);
        return AuthResponse.builder().token(jwtToken).build();
    }

}
