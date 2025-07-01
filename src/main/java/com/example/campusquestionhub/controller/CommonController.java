package com.example.campusquestionhub.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CommonController {
    @GetMapping("/userlogout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/"; // Redirect to main page
    }
    @GetMapping("/")
    public String root(HttpSession session) {
        if (session.getAttribute("email") != null) {
            String role = (String) session.getAttribute("role");
            if ("ADMIN".equals(role)) return "redirect:/adminhome.html";
            if ("STUDENT".equals(role)) return "redirect:/studenthome.html";
        }
        return "redirect:/index.html";
    }

}
