package com.example.campusquestionhub.controller;

import com.example.campusquestionhub.model.Paper;
import com.example.campusquestionhub.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class PaperController {

    @Autowired
    private AdminService adminService;


    @PostMapping("/upload")
    public ResponseEntity<String> uploadPaper(
            @RequestParam String course,
            @RequestParam String subject,
            @RequestParam int year,
            @RequestParam MultipartFile file) {

        String response = adminService.uploadPaper(course, subject, year, file);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/view_papers")
    public ResponseEntity<List<Paper>> getAllPapers() {
        return ResponseEntity.ok(adminService.getAllPapers());
    }


    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadPaper(@PathVariable Long id) {
        Optional<Paper> paper = adminService.getPaperById(id);

        if (paper.isPresent()) {
            Paper p = paper.get();
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + p.getFileName() + "\"")
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(p.getFileData());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}

