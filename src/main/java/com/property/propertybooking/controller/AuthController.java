package com.property.propertybooking.controller;

import com.property.propertybooking.dto.LoginRequest;
import com.property.propertybooking.dto.LoginResponse;
import com.property.propertybooking.dto.RegisterRequest;
import com.property.propertybooking.entity.User;
import com.property.propertybooking.service.AuthService;
import com.property.propertybooking.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

	 private final UserService userService;
	    private final AuthService authService;

	    public AuthController(UserService userService, AuthService authService) {
	        this.userService = userService;
	        this.authService = authService;
	    }

	    @PostMapping("/register")
	    public User register(@Valid @RequestBody RegisterRequest request) {
	        return userService.register(request);
	    }

	    @PostMapping("/login")
	    public LoginResponse login(@Valid @RequestBody LoginRequest request) {
	        return authService.login(request);
	    }
}
