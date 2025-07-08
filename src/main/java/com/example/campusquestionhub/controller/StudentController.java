package com.example.campusquestionhub.controller;

import com.example.campusquestionhub.model.Student;
import com.example.campusquestionhub.repository.StudentRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/register")
   
    public String registerStudent(@RequestParam String email,
                                  @RequestParam String password,
                                  @RequestParam String name,
                                  @RequestParam String studentId,
                                  @RequestParam String phoneNo) {

        Student student = new Student();
        student.setEmail(email);
        student.setPassword(passwordEncoder.encode(password));
        student.setName(name);
        student.setStudentId(studentId);
        student.setPhoneNo(phoneNo);

        studentRepository.save(student);
        return "redirect:/studentlogin.html";
    }

    @PostMapping("/login")
    public String loginStudent(@RequestParam String email,
                               @RequestParam String password,
                               HttpSession session) {
        Optional<Student> student = studentRepository.findByEmail(email);

        if (student.isPresent() && passwordEncoder.matches(password, student.get().getPassword())) {
            session.setAttribute("email", student.get().getEmail());
            session.setAttribute("role", "STUDENT");

            return "redirect:/studenthome.html";
        } else {
            return "redirect:/studentlogin.html?error=true";
        }
    }

}
