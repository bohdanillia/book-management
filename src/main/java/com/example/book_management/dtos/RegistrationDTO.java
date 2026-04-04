package com.example.book_management.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegistrationDTO {

    @NotBlank(message = "Email cannot be empty")
    @Email
    private String email;

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 6)
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
