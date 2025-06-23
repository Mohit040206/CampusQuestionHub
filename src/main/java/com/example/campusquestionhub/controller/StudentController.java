package com.example.campusquestionhub.controller;


import com.example.campusquestionhub.model.Student;
import com.example.campusquestionhub.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;
    @PostMapping("/register")
    public ResponseEntity<String> registerRegister(@RequestParam String email, @RequestParam String password){
       Student student= new Student();
       student.setEmail(email);
       student.setPassword(password);
       studentRepository.save(student);
       return ResponseEntity.ok("Registered Succesfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginStudent(@RequestParam String email,@RequestParam String password){
        Optional<Student> student=studentRepository.findByEmail(email);

        if(student.isPresent() && student.get().getPassword().equals(password)){
            return ResponseEntity.ok("Login Successfully");
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
        }
    }
}


