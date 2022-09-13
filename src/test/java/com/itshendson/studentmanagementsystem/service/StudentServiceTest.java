package com.itshendson.studentmanagementsystem.service;

import com.itshendson.studentmanagementsystem.repository.StudentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;
    private StudentService underTest;
    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        // If we have more than one mock test, it'll initialize them in this test class.
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new StudentService(studentRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close(); // Closes our resource after the test.
    }

    @DisplayName("Get all students")
    @Test
    void fetchStudentList() {
        // when
        underTest.fetchStudentList();

        // then
        verify(studentRepository).findAll(); // verify that studentRepository was ran by invoking findAll()

    }
}