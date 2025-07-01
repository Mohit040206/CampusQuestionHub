package com.example.campusquestionhub.controller;

import com.example.campusquestionhub.model.Admin;
import com.example.campusquestionhub.repository.AdminRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @PostMapping("/login")
    public String loginAdmin(@RequestParam String email,
                             @RequestParam String password,
                             HttpSession session) {
        Optional<Admin> admin = adminRepository.findByEmail(email);

        if (admin.isPresent()) {
            if (admin.get().getPassword().equals(password)) {
                // Save session data
                session.setAttribute("email", admin.get().getEmail());
                session.setAttribute("role", "ADMIN");

                //  Redirect to admin home
                return "redirect:/adminhome.html";
            } else {
                //  Invalid credentials
                return "redirect:/login.html?error=invalid";
            }
        } else {
            //  Admin not found
            return "redirect:/login.html?error=notfound";
        }
    }
}
