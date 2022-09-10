package com.itshendson.studentmanagementsystem.entity;

public enum Faculty {
    ARTS("ART"),
    BUSINESS("BUS"),
    COMMUNICATION("COM"),
    DENTISTRY("DEN"),
    LAW("LAW"),
    MEDICINE("MED"),
    MUSIC("MUS"),
    SCIENCE("SCI");

    private String facultyCode;

    private Faculty(String facultyCode) {
        this.facultyCode = facultyCode;
    }

    public String getFacultyCode() {
        return facultyCode;
    }
}
