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

import java.util.List;
import java.util.Optional;

class BookServiceTest {
    @InjectMocks
    private BookService bookService;
    @Mock
    private BookRepository bookRepository;

    @Test
    public void addBookTest(){
        BookEntity savedEntity = new BookEntity();
        savedEntity.setId(1L);
        savedEntity.setTitle("Harry Potter");
        savedEntity.setAuthor("Rowling");
        savedEntity.setDescription("Favourite book");
        savedEntity.setYear(1998);

        BookDTO dto = new BookDTO();
        dto.setTitle("Harry Potter");
        dto.setAuthor("Rowling");
        dto.setDescription("Favourite book");
        dto.setYear(1998);

        Mockito.when(bookRepository.save(Mockito.any(BookEntity.class))).thenReturn(savedEntity);

        BookDTO result = bookService.addBook(dto);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(dto.getTitle(), result.getTitle());
        Assertions.assertEquals(dto.getAuthor(), result.getAuthor());
        Assertions.assertEquals(dto.getDescription(), result.getDescription());
        Assertions.assertEquals(dto.getYear(), result.getYear());
    }

    @Test
    public void getBookByIdTest(){
        BookEntity entity = new BookEntity();
        entity.setId(1L);
        entity.setTitle("Harry Potter");
        entity.setAuthor("Rowling");
        entity.setDescription("Favourite book");
        entity.setYear(1998);

        Mockito.when(bookRepository.findById(1L)).thenReturn(Optional.of(entity));

        BookDTO saved = bookService.getBookById(1L);

        Assertions.assertNotNull(saved);
        Assertions.assertEquals(entity.getId(), saved.getId());
        Assertions.assertEquals(entity.getAuthor(), saved.getAuthor());
        Assertions.assertEquals(entity.getDescription(), saved.getDescription());
        Assertions.assertEquals(entity.getYear(), saved.getYear());
    }

    @Test
    public void getAllBooks(){
        BookEntity b1 = new BookEntity();
        b1.setTitle("Harry Potter");
        b1.setAuthor("Rowling");
        b1.setDescription("Favourite book");
        b1.setYear(1998);

        BookEntity b2 = new BookEntity();
        b2.setTitle("Harry Potter 2");
        b2.setAuthor("J.K. Rowling");
        b2.setDescription("Favourite book 2");
        b2.setYear(1998);

        BookEntity b3 = new BookEntity();
        b3.setTitle("Harry Potter 3");
        b3.setAuthor("Rowling");
        b3.setDescription("Favourite book 2");
        b3.setYear(1998);

        Mockito.when(bookRepository.findAll()).thenReturn(List.of(b1, b2, b3));

        List<BookDTO> result = bookService.getAllBooks();
        Assertions.assertNotNull(result);
        Assertions.assertEquals(b1.getTitle(), result.getFirst().getTitle());
        Assertions.assertEquals(b2.getTitle(), result.get(1).getTitle());
        Assertions.assertEquals(b3.getTitle(), result.get(2).getTitle());
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
}