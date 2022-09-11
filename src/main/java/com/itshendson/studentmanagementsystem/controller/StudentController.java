package com.itshendson.studentmanagementsystem.controller;

import com.itshendson.studentmanagementsystem.entity.Student;
import com.itshendson.studentmanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student")
    public List<Student> fetchStudentList() {
        return studentService.fetchStudentList();
    }

    @GetMapping("/student/{id}")
    public Student fetchStudentById(@PathVariable("id") Long studentId) {
        return studentService.fetchStudentById(studentId);
    }

    @GetMapping("/student/name/{name}")
    public List<Student> fetchAllStudentsByFirstName(@PathVariable("name") String firstName) {
        return studentService.fetchAllStudentsByFirstName(firstName);
    }

    @PostMapping("/student")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudentById(@PathVariable("id") Long studentId) {
        String message = "Student deleted.";
        studentService.deleteStudentById(studentId);
        return message;
    }

    @GetMapping("/")
    public String getHome() {
        return "Hello World";
    }
}
