package com.book.repo;

import com.book.model.PurchaseHistory;
import com.book.repo.projection.IPurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseHistoryRepo extends JpaRepository<PurchaseHistory, Long> {


    @Query("select b.title as title, b.price as price, ph.localDateTime as localDateTime from PurchaseHistory ph left join Book b on b.id = ph.bookId where ph.userId = :userId")
    List<IPurchaseItem> findAllByPurchaseOfUser(@Param("userId") Long userId);
}
