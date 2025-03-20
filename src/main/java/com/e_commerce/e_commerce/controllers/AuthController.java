package com.e_commerce.e_commerce.controllers;

import com.e_commerce.e_commerce.dto.UserDTO;
import com.e_commerce.e_commerce.models.User;
import com.e_commerce.e_commerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired

    private UserService userService;

    @PostMapping("/signup")

    public UserDTO signup (@RequestBody User user) {
        return userService.registerUser(user);
    }
    @PostMapping("/signin")
    public ResponseEntity<?> loginPage(@RequestBody User user) {
        return userService.loginpage(user);
    }

}
