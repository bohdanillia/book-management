package com.example.book_management.dtos;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserDTO {

    private int id;
    @NotBlank(message = "Email cannot be empty")
    @Email
    private String email;
    @NotBlank(message = "Password cannot be empty")

    private String password;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }


        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }


    }


