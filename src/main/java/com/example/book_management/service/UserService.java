package com.example.book_management.service;

import com.example.book_management.dtos.UserDTO;
import com.example.book_management.entities.UserEntity;
import com.example.book_management.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.InvalidParameterException;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDTO register(String email, String password){
        if(email == null || email.isBlank()){
            throw new InvalidParameterException("Email cannot be empty");
        }
        if(password == null|| password.length() < 6){
            throw new InvalidParameterException("Password minimal length is 6");
        }

        UserEntity newUser = new UserEntity();

        newUser.setEmail(email);
        newUser.setPassword(passwordEncoder.encode(password));
        userRepository.save(newUser);

        UserDTO userDTO = new UserDTO();
        userDTO.setId(newUser.getId());
        userDTO.setEmail(newUser.getEmail());
        return userDTO;
    }

    public UserDTO login(String email, String password){
        if(email == null || email.isBlank()){
            throw new InvalidParameterException("Email cannot be empty");
        }
        if(password == null || password.length() < 6){
            throw new InvalidParameterException("Password minimal length is 6");
        }

        UserEntity user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));

        if(!passwordEncoder.matches(password, user.getPassword())){
            throw new InvalidParameterException("Password is incorrect");
        }

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }
}
