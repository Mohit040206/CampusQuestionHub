package com.example.campusquestionhub.model;


import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;
@Entity
public class Paper {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;




    private String course;
    private String subject;
    private int year;
    private String fileName;
    @Lob
    private byte[] fileData;
    private String uploadedBy;
    private String filePath;

    public long getId(){
        return id;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }



    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public int getYear() {
        return year;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
