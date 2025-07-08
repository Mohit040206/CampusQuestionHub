package com.example.campusquestionhub.controller;

import com.example.campusquestionhub.model.Paper;
import com.example.campusquestionhub.repository.PaperRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ViewDownloadPaperController {
    @Autowired
    PaperRepository paperRepository;
    @GetMapping("/viewpapers")
    public String showPapersPage(HttpSession session, Model model) {
        if (session.getAttribute("email") == null || session.getAttribute("role") == null) {
            return "redirect:/index.html";
        }
        List<Paper> papers = paperRepository.findAll();
        model.addAttribute("papers", papers);


        return "downloadpapers";
    }
    // ✅ Filtered search by course/subject/year
    @GetMapping("/viewpapers/search")
    public String searchPapers(
            @RequestParam(required = false) String course,
            @RequestParam(required = false) String subject,
            @RequestParam(required = false) Integer year,
            Model model,
            HttpSession session) {

        if (session.getAttribute("email") == null || session.getAttribute("role") == null) {
            return "redirect:/index.html";
        }

        List<Paper> filtered = paperRepository.findAll().stream()
                .filter(p -> (course == null || course.isEmpty() || p.getCourse().equalsIgnoreCase(course)) &&
                        (subject == null || subject.isEmpty() || p.getSubject().equalsIgnoreCase(subject)) &&
                        (year == null || p.getYear() == year))
                .collect(Collectors.toList());

        model.addAttribute("papers", filtered);
        return "downloadpapers"; // same view page
    }
    // ✅ Show the Upload Page (only view, not POST)
    @GetMapping("/upload")
    public String showUploadPage(HttpSession session) {
        if (session.getAttribute("email") == null || session.getAttribute("role") == null ||
                !session.getAttribute("role").equals("admin")) {
            return "redirect:/index.html";
        }
        return "upload"; // Will render templates/upload.html
    }
}



