package com.itshendson.studentmanagementsystem.service;

import com.itshendson.studentmanagementsystem.entity.Student;
import com.itshendson.studentmanagementsystem.exception.StudentNotFoundException;

import java.util.List;

public interface StudentServiceInterface {

    Student saveStudent(Student student);

    List<Student> fetchStudentList();

    Student fetchStudentById(Long studentId) throws StudentNotFoundException;

    void deleteStudentById(Long studentId) throws StudentNotFoundException;

    List<Student> fetchAllStudentsByFirstName(String firstName);
}
