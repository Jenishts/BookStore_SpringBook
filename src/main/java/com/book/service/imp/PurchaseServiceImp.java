package com.book.service.imp;

import com.book.model.PurchaseHistory;
import com.book.repo.PurchaseHistoryRepo;
import com.book.repo.projection.IPurchaseItem;
import com.book.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseServiceImp implements PurchaseService {

    private final PurchaseHistoryRepo purchaseHistoryRepo;

    @Override
    public PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory){
        purchaseHistory.setLocalDateTime(LocalDateTime.now());
        return purchaseHistoryRepo.save(purchaseHistory);

    }
    @Override
    public List<IPurchaseItem> findByUser(Long id){
        return purchaseHistoryRepo.findAllByPurchaseOfUser(id);
    }
}
