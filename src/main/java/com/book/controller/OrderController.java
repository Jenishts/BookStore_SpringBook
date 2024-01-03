package com.book.controller;

import com.book.model.PurchaseBook;
import com.book.model.PurchaseHistory;
import com.book.model.User;
import com.book.repo.projection.IPurchaseItem;
import com.book.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final PurchaseService purchaseService;


    @PostMapping()
    public PurchaseHistory saveOrder(@AuthenticationPrincipal User user, @RequestBody PurchaseBook book){
        PurchaseHistory ph=new PurchaseHistory();
        ph.setUserId(user.getId());
        ph.setBookId(book.getBookId());

        return purchaseService.savePurchaseHistory(ph);
    }

    @GetMapping()
    public ResponseEntity<List<IPurchaseItem>> findAll(@AuthenticationPrincipal User user){
        return ResponseEntity.ok(purchaseService.findByUser(user.getId()));
    }

}
