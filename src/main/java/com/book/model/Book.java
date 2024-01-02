package com.book.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "Book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Title", nullable = false, length = 100)
    private String title;

    @Column(name = "Description", nullable = false, length = 500)
    private String description;

    @Column(name = "Author", nullable = false, length = 100)

    private String author;

    @Column(name = "Price", nullable = false)

    private Double price;

    @Column(name = "Create_Time", nullable = false)

    private LocalDateTime localDateTime;
}
