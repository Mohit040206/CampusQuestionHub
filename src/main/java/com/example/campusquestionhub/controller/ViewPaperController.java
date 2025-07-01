package com.example.campusquestionhub.controller;

import com.example.campusquestionhub.model.Paper;
import com.example.campusquestionhub.repository.PaperRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ViewPaperController {
    @Autowired
    PaperRepository paperRepository;
    @GetMapping("/viewpapers")
    public String showPapersPage(HttpSession session, Model model) {
        if (session.getAttribute("email") == null || session.getAttribute("role") == null) {
            return "redirect:/index.html";
        }
        List<Paper> papers = paperRepository.findAll();
        model.addAttribute("papers", papers);


        return "viewpapers";
    }

}
