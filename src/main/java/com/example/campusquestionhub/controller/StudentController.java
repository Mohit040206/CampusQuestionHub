package com.example.campusquestionhub.controller;


import com.example.campusquestionhub.model.Student;
import com.example.campusquestionhub.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerRegister(@RequestParam String email, @RequestParam String password,@RequestParam String name, @RequestParam String studentId,@RequestParam String phoneNo){
       Student student= new Student();
       student.setEmail(email);
       student.setPassword(passwordEncoder.encode(password));
       student.setStudentId(studentId);
       student.setName(name);
       student.setPhoneNo(phoneNo);
       studentRepository.save(student);
       return ResponseEntity.ok("Registered Succesfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginStudent(@RequestParam String email,@RequestParam String password){
        Optional<Student> student=studentRepository.findByEmail(email);

        if(student.isPresent() && passwordEncoder.matches(password, student.get().getPassword())){
            return ResponseEntity.ok("Login Successfully");
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
        }
    }
}


