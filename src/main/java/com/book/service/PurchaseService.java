package com.book.service;

import com.book.model.PurchaseHistory;
import com.book.repo.projection.IPurchaseItem;

import java.util.List;

public interface PurchaseService {
    PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory);

    List<IPurchaseItem> findByUser(Long id);
}
