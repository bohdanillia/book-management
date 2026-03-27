package com.example.book_management.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class BookEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String author;
	private int year;
	private String description;



	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public int getYear() {
		return year;
	}

	public String getDescription() {
		return description;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
