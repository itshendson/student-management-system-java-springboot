package com.itshendson.studentmanagementsystem.entity;

import com.itshendson.studentmanagementsystem.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Autowired
    Student testStudent;

    @Test
    void getFaculty() {
        testStudent = new Student("Test", "Dummy", Faculty.ARTS);
        assertEquals("Arts", testStudent.getFaculty());
    }
}