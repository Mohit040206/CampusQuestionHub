package com.example.campusquestionhub.controller;

import com.example.campusquestionhub.model.Admin;
import com.example.campusquestionhub.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;


import com.example.campusquestionhub.model.Admin;
import com.example.campusquestionhub.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;


    @PostMapping("/login")
    public ResponseEntity<String> loginAdmin(@RequestParam String email, @RequestParam String password) {
        Optional<Admin> admin = adminRepository.findByEmail(email);

        if (admin.isPresent()) {
            if (admin.get().getPassword().equals(password)) {
                return ResponseEntity.ok("Login successful");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Admin not found");
        }
    }
}
