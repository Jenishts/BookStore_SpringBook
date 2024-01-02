package com.book.service.imp;

import com.book.model.Book;
import com.book.repo.BookRepo;
import com.book.service.BService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BServiceImp implements BService {

    private final BookRepo bookRepo;


    @Override

    public Book saveBook(Book book){
        return bookRepo.save(book);
    }

    @Override

    public void deleteBook(Long id){
        bookRepo.deleteById(id);
    }

    @Override

    public List<Book> listBook(){
        return bookRepo.findAll();
    }


}
