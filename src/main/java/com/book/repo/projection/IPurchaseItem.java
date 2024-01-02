package com.book.repo.projection;

import java.time.LocalDateTime;

public interface IPurchaseItem {
    String getTitle();

    Double getPrice();
    LocalDateTime getlocalDateTime();
}
