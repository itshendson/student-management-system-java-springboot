package com.itshendson.studentmanagementsystem.entity;

import com.itshendson.studentmanagementsystem.service.StudentService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Student testStudent = new Student("Test", "Dummy", Faculty.ARTS);

    @Test
    void getFaculty() {
        assertEquals(Faculty.ARTS, testStudent.getFaculty());
    }
}