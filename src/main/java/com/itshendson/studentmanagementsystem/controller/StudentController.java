package com.itshendson.studentmanagementsystem.controller;

import com.itshendson.studentmanagementsystem.entity.Student;
import com.itshendson.studentmanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping("/students")
    public List<Student> fetchStudentList() {
        return studentService.fetchStudentList();
    }

    @GetMapping("/")
    public String getHome() {
        return "Hello World";
    }
}
