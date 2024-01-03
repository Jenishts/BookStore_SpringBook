package com.book.controller;

import com.book.model.Book;
import com.book.service.BService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")

public class BookController {

    private final BService bService;


    @PostMapping("")
    ResponseEntity<Book> save(@RequestBody Book book){
        return ResponseEntity.ok(bService.saveBook(book));
    }

    @DeleteMapping("{id}")
    ResponseEntity<String> delete(@PathVariable("id") Long id){

        bService.deleteBook(id);
        return ResponseEntity.ok("Deleted");
    }

    @GetMapping()
    ResponseEntity<List<Book>> listBook(){
        return ResponseEntity.ok(bService.listBook());
    }

}
