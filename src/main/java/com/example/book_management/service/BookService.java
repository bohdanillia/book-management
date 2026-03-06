package com.example.book_management.service;

import com.example.book_management.entities.BookEntity;
import com.example.book_management.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository){
		this.bookRepository = bookRepository;
	}

	public void addBook(BookEntity book){
		bookRepository.save(book);
	}

	public Optional<BookEntity> getBookById(Long id){
		return bookRepository.findById(id);
	}

	public List<BookEntity> getAllBooks(){
		return bookRepository.findAll();
	}

	public BookEntity updateBook(Long id, BookEntity updatedBook){
		BookEntity bookToUpdate = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
		bookToUpdate.setAuthor(updatedBook.getAuthor());
		bookToUpdate.setDescription(updatedBook.getDescription());
		bookToUpdate.setYear(updatedBook.getYear());

		return bookRepository.save(bookToUpdate);
	}

	public void deleteBookById(Long id){
		bookRepository.deleteById(id);
	}
}
