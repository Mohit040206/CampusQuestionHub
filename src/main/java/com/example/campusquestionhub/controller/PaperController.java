package com.example.campusquestionhub.controller;

import com.example.campusquestionhub.model.Paper;
import com.example.campusquestionhub.repository.PaperRepository;
import com.example.campusquestionhub.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.*;

@RestController
@RequestMapping("/admin")
public class PaperController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private PaperRepository paperRepository;


    @PostMapping("/upload")
    public ResponseEntity<String> uploadPaper(
            @RequestParam String course,
            @RequestParam String subject,
            @RequestParam int year,
            @RequestParam MultipartFile file) {


        try {
            // Save file to disk
            String uploadDir = System.getProperty("user.dir") + "/uploads/";

            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            String originalFilename = file.getOriginalFilename();
            String filePath = uploadDir + UUID.randomUUID() + "_" + originalFilename;
            File dest = new File(filePath);
            file.transferTo(dest); // Save the file to disk

            // Save metadata in DB
            Paper paper = new Paper();
            paper.setCourse(course);
            paper.setSubject(subject);
            paper.setYear(year);
            paper.setFileName(originalFilename);
            paper.setFilePath(filePath);
            paper.setUploadedBy("Admin");


            paperRepository.save(paper);

            return ResponseEntity.ok("Paper uploaded successfully");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to upload: " + e.getMessage());
        }
    }


    @GetMapping("/papers/view")
    public ResponseEntity<List<Map<String, Object>>> viewAllPapers() {
        List<Paper> papers = paperRepository.findAll();
        List<Map<String, Object>> response = new ArrayList<>();

        for (Paper paper : papers) {
            Map<String, Object> paperInfo = new HashMap<>();
            paperInfo.put("id", paper.getId());
            paperInfo.put("fileName", paper.getFileName());
            paperInfo.put("subject", paper.getSubject());
            paperInfo.put("year", paper.getYear());
            paperInfo.put("course", paper.getCourse());
            paperInfo.put("uploadedBy", paper.getUploadedBy());
            response.add(paperInfo);
        }

        return ResponseEntity.ok(response);
    }



    @GetMapping("/papers/download/{id}")
    public ResponseEntity<Resource> downloadPaper(@PathVariable Long id) throws IOException {
        Paper paper = paperRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paper not found with ID: " + id));

        Path path = Paths.get(paper.getFilePath());
        Resource resource = new UrlResource(path.toUri());

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + paper.getFileName() + "\"")
                .body(resource);
    }

}

