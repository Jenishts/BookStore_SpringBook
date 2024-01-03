package com.book.service.imp;

import com.book.model.Role;
import com.book.model.User;
import com.book.repo.UserRepo;
import com.book.service.UService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UServiceImp implements UService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;


    @Override
    public User saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        return userRepo.save(user);
    }

    @Override
    public Optional<User> findByUserName(String username){
        return userRepo.findByUserName(username);
    }

    @Transactional
    @Override
    public void makeAdmin(String username){
        userRepo.updateUserRole(username, Role.ADMIN);
    }

}
