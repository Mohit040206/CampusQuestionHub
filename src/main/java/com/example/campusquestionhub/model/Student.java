package com.example.campusquestionhub.model;


import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return email;
    }public void setPassword(String password){
        this.password=password;
    }
    public String getPassword(){
        return password;
    }
}
