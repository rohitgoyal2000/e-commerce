package com.e_commerce.e_commerce.service;

import com.e_commerce.e_commerce.dto.UserDTO;
import com.e_commerce.e_commerce.models.User;
import com.e_commerce.e_commerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserDTO registerUser (User user) {

        Optional<User>existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser.isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        // Hash code before saving the password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User savedUser = userRepository.save(user);

        return new UserDTO(
                savedUser.getFullName(),
                savedUser.getEmail(),
                savedUser.getPhoneNumber(),
                savedUser.getAddress(),
                savedUser.getCity(),
                savedUser.getCity(),
                savedUser.getZipCode()
        );

    }


    public ResponseEntity<?> loginpage(User loginRequest) {

        Optional<User> existingUser = userRepository.findByEmail(loginRequest.getEmail());

        if (existingUser.isPresent()) {
            User user = existingUser.get();
            if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                return ResponseEntity.ok("Login successful!");
            } else {
                return ResponseEntity.status(401).body("Invalid credentials");
            }
        } else {
            return ResponseEntity.status(404).body("User not found!");
        }
    }

}
