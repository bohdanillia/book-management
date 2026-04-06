package com.example.book_management.dtos;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class BookDTO {
    Long id;
    @NotBlank(message = "Title cannot be empty")
    private String title;
    private String author;
    @Min(value = 1500, message = "Year should be more than 1500")
    @Max(value = 2026, message = "Year should be less than 2026")
    private int year;
    @Size(max = 300)
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
