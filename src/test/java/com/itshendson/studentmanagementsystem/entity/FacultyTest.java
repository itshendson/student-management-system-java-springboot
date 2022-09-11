package com.itshendson.studentmanagementsystem.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FacultyTest {

    @Autowired
    Student testStudent;


    @Test
    void getArtFacultyCode() {
        testStudent = new Student("Test", "Dummy", Faculty.ARTS);
        assertEquals("ART", testStudent.getFaculty().getFacultyCode());
    }

    @Test
    void getBusFacultyCode() {
        testStudent = new Student("Test", "Dummy", Faculty.BUSINESS);
        assertEquals("BUS", testStudent.getFaculty().getFacultyCode());
    }

    @Test
    void getCOMFacultyCode() {
        testStudent = new Student("Test", "Dummy", Faculty.COMMUNICATION);
        assertEquals("COM", testStudent.getFaculty().getFacultyCode());
    }

    @Test
    void getDenFacultyCode() {
        testStudent = new Student("Test", "Dummy", Faculty.DENTISTRY);
        assertEquals("DEN", testStudent.getFaculty().getFacultyCode());
    }

    @Test
    void getLawFacultyCode() {
        testStudent = new Student("Test", "Dummy", Faculty.LAW);
        assertEquals("LAW", testStudent.getFaculty().getFacultyCode());
    }

    @Test
    void getMedFacultyCode() {
        testStudent = new Student("Test", "Dummy", Faculty.MEDICINE);
        assertEquals("MED", testStudent.getFaculty().getFacultyCode());
    }

    @Test
    void getMusFacultyCode() {
        testStudent = new Student("Test", "Dummy", Faculty.MUSIC);
        assertEquals("MUS", testStudent.getFaculty().getFacultyCode());
    }

    @Test
    void getSciFacultyCode() {
        testStudent = new Student("Test", "Dummy", Faculty.SCIENCE);
        assertEquals("SCI", testStudent.getFaculty().getFacultyCode());
    }
}