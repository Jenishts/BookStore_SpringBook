package com.book.service;

import com.book.model.User;
import jakarta.transaction.Transactional;

import java.util.Optional;

public interface UService {
    User saveUser(User user);

    Optional<User> findByUserName(String username);

    @Transactional
    void makeAdmin(String username);
}
