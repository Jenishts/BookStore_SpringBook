package com.book.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Purchased_Order")
public class PurchaseHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    // to avoid performace issue, we are using native sql query to fetch details instead of using many to one relationship

    @Column(name = "User_Id", nullable = false)
    private Long userId;



    @Column(name = "Book_Id", nullable = false)
    private Long bookId;

    @Column(name = "Price", nullable = false)
    private Double price;

    @Column(name = "Order_time", nullable = false)
    private LocalDateTime localDateTime;
}
