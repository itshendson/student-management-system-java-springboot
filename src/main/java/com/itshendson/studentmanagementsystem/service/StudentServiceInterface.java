package com.itshendson.studentmanagementsystem.service;

import com.itshendson.studentmanagementsystem.entity.Student;

import java.util.List;

public interface StudentServiceInterface {

    Student saveStudent(Student student);

    List<Student> fetchStudentList();

    Student fetchStudentById(Long studentId);

    void deleteStudentById(Long studentId);

    List<Student> fetchAllStudentsByFirstName(String firstName);
}
