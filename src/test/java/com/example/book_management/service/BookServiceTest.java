package com.example.book_management.service;

import com.example.book_management.dtos.BookDTO;
import com.example.book_management.entities.BookEntity;
import com.example.book_management.repositories.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookServiceTest {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookRepository bookRepository;

    @Test
    public void addBookTest(){
        BookEntity entity = new BookEntity();
        entity.setTitle("Harry Potter");
        entity.setAuthor("Rowling");
        entity.setDescription("Favourite book");
        entity.setYear(1998);

        BookDTO dto = bookService.toDTO(entity);
        BookDTO saved = bookService.addBook(dto);

        Assertions.assertNotNull(saved.getId());
        Assertions.assertTrue(bookRepository.findById(saved.getId()).isPresent());
    }
}