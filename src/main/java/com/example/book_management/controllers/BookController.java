package com.example.book_management.controllers;

import com.example.book_management.entities.BookEntity;
import com.example.book_management.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public Optional<BookEntity> getBookById(@PathVariable Long id){
        return bookService.getBookById(id);
    }

    @GetMapping("/")
    public List<BookEntity> getAllBooks(){
        return bookService.getAllBooks();
    }
    @PutMapping("/{id}")
    public BookEntity updateBook(@PathVariable Long id, @RequestBody BookEntity updatedBook){
        return bookService.updateBook(id, updatedBook);
    }

    @PostMapping("/")
    public BookEntity addBook(@RequestBody BookEntity book){
        return bookService.addBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable Long id){
        bookService.deleteBookById(id);
    }
}
