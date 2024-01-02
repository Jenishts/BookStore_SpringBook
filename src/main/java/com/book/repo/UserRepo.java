package com.book.repo;

import com.book.model.Role;
import com.book.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String username);


    @Modifying
    @Query("update User set role=:role where userName=:username")
    void updateUserRole(@Param("username") String userName, @Param("role") Role role);

}
