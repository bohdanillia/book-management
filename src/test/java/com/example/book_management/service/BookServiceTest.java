package com.example.book_management.service;

import com.example.book_management.dtos.BookDTO;
import com.example.book_management.entities.BookEntity;
import com.example.book_management.repositories.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

class BookServiceTest {
    @InjectMocks
    private BookService bookService;
    @Mock
    private BookRepository bookRepository;

    @Test
    public void addBookTest(){
        BookEntity entity = new BookEntity();
        entity.setId(1L);
        entity.setTitle("Harry Potter");
        entity.setAuthor("Rowling");
        entity.setDescription("Favourite book");
        entity.setYear(1998);

        BookDTO dto = new BookDTO();
        entity.setTitle("Harry Potter");
        entity.setAuthor("Rowling");
        entity.setDescription("Favourite book");
        entity.setYear(1998);

        Mockito.when(bookRepository.save(Mockito.any(BookEntity.class))).thenReturn(entity);
        Mockito.when(bookRepository.findById(entity.getId())).thenReturn(Optional.of(entity));

        BookDTO saved = bookService.addBook(dto);

        Assertions.assertNotNull(saved.getId());
        Assertions.assertTrue(bookRepository.findById(saved.getId()).isPresent());
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
}