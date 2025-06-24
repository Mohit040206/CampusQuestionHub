package com.example.campusquestionhub.service;


import com.example.campusquestionhub.model.Paper;
import com.example.campusquestionhub.repository.PaperRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private PaperRepository paperRepository;

    public String uploadPaper(String course, String subject, int year, MultipartFile file ){
        try {
            Paper paper = new Paper();
            paper.setCourse(course);
            paper.setSubject(subject);
            paper.setYear(year);
            paper.setFileName(file.getOriginalFilename());
            paper.setUploadedBy("Admin");
            paper.setFileData(file.getBytes());

            paperRepository.save(paper);
            return "Paper Uploaded Successfully";
        }catch (IOException e){
            return "Error in uploading" + e.getMessage();
        }

    }
    public List<Paper> getAllPapers(){
        return paperRepository.findAll();
    }
    public Optional<Paper> getPaperById(Long id) {
        return paperRepository.findById(id);
    }
}
