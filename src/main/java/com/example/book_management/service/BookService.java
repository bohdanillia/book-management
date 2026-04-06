package com.example.book_management.service;

import com.example.book_management.dtos.BookDTO;
import com.example.book_management.entities.BookEntity;
import com.example.book_management.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository){
		this.bookRepository = bookRepository;
	}

	public BookDTO addBook(BookDTO book){
		BookEntity entity = toEntity(book);
		return toDTO(bookRepository.save(entity));
	}

	public BookDTO getBookById(Long id){
		BookEntity book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
		return toDTO(book);
	}

	public List<BookDTO> getAllBooks(){
		return bookRepository.findAll()
				.stream()
				.map(this::toDTO)
				.toList();
	}

	public BookDTO updateBook(Long id, BookDTO updatedBook){
		BookEntity bookToUpdate = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
		bookToUpdate.setTitle(updatedBook.getTitle());
		bookToUpdate.setAuthor(updatedBook.getAuthor());
		bookToUpdate.setDescription(updatedBook.getDescription());
		bookToUpdate.setYear(updatedBook.getYear());

		return toDTO(bookRepository.save(bookToUpdate));
	}

	public BookEntity toEntity(BookDTO bookDTO){
		BookEntity bookEntity = new BookEntity();
		bookEntity.setTitle(bookDTO.getTitle());
		bookEntity.setAuthor(bookDTO.getAuthor());
		bookEntity.setYear(bookDTO.getYear());
		bookEntity.setDescription(bookDTO.getDescription());
		return bookEntity;
	}

	public BookDTO toDTO(BookEntity bookEntity){
		BookDTO bookDTO = new BookDTO();
		bookDTO.setTitle(bookEntity.getTitle());
		bookDTO.setAuthor(bookEntity.getAuthor());
		bookDTO.setYear(bookEntity.getYear());
		bookDTO.setDescription(bookEntity.getDescription());
		return bookDTO;
	}

	public void deleteBookById(Long id){
		bookRepository.deleteById(id);
	}
}
