package com.example.book_management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;

@Repository
public interface bookRepository extends JpaRepository<Book, Long> {
}
