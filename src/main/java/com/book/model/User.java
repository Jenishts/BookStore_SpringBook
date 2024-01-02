package com.book.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "_User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "UserName", unique = true, nullable = false, length = 100)
    private String userName;

    @Column(name = "Password", nullable = false, length = 100)
    private String password;

    @Column(name = "Name", unique = true, length = 100)
    private String name;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "Create_Time", nullable = false)

    private LocalDateTime localDateTime;
}
