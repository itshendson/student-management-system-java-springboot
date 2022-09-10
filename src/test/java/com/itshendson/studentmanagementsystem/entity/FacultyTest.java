package com.itshendson.studentmanagementsystem.entity;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FacultyTest {


    @Test
    void getArtFacultyCode() {
        Student testStudent = new Student("Test", "Dummy", Faculty.ARTS);
        assertEquals("ART", testStudent.getFaculty().getFacultyCode());
    }

    @Test
    void getBusFacultyCode() {
        Student testStudent = new Student("Test", "Dummy", Faculty.BUSINESS);
        assertEquals("BUS", testStudent.getFaculty().getFacultyCode());
    }

    @Test
    void getCOMFacultyCode() {
        Student testStudent = new Student("Test", "Dummy", Faculty.COMMUNICATION);
        assertEquals("COM", testStudent.getFaculty().getFacultyCode());
    }

    @Test
    void getDenFacultyCode() {
        Student testStudent = new Student("Test", "Dummy", Faculty.DENTISTRY);
        assertEquals("DEN", testStudent.getFaculty().getFacultyCode());
    }

    @Test
    void getLawFacultyCode() {
        Student testStudent = new Student("Test", "Dummy", Faculty.LAW);
        assertEquals("LAW", testStudent.getFaculty().getFacultyCode());
    }

    @Test
    void getMedFacultyCode() {
        Student testStudent = new Student("Test", "Dummy", Faculty.MEDICINE);
        assertEquals("MED", testStudent.getFaculty().getFacultyCode());
    }

    @Test
    void getMusFacultyCode() {
        Student testStudent = new Student("Test", "Dummy", Faculty.MUSIC);
        assertEquals("MUS", testStudent.getFaculty().getFacultyCode());
    }

    @Test
    void getSciFacultyCode() {
        Student testStudent = new Student("Test", "Dummy", Faculty.SCIENCE);
        assertEquals("SCI", testStudent.getFaculty().getFacultyCode());
    }
}