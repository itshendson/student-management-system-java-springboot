package com.itshendson.studentmanagementsystem.service;

import com.itshendson.studentmanagementsystem.entity.Faculty;
import com.itshendson.studentmanagementsystem.entity.Student;
import com.itshendson.studentmanagementsystem.exception.StudentNotFoundException;
import com.itshendson.studentmanagementsystem.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepositoryMock;
    @InjectMocks
    private StudentService studentServiceTest;
    private Student studentOne;
    private Student studentTwo;
    private Student studentThree;

    @BeforeEach
    void setUp() {
        studentOne = Student.builder()
                .studentId(1L)
                .firstName("French Fries")
                .lastName("McGovern")
                .faculty(Faculty.BUSINESS)
                .build();

        studentTwo = Student.builder()
                .studentId(2L)
                .firstName("Glizzy")
                .lastName("Golden")
                .faculty(Faculty.COMMUNICATION)
                .build();

        studentThree = Student.builder()
                .studentId(3L)
                .firstName("French Fries")
                .lastName("Salty")
                .faculty(Faculty.MUSIC)
                .build();
    }

    @DisplayName("When StudentService invokes saveStudent(), studentRepository should invoke save()")
    @Test
    void saveValidStudentTest() {
        // when
        when(studentRepositoryMock.save(studentOne)).thenReturn(studentOne);
        // then
        assertEquals(studentOne, studentServiceTest.saveStudent(studentOne));
        verify(studentRepositoryMock).save(studentOne);
        verify(studentRepositoryMock, times(1)).save(studentOne);
    }

    @Disabled
    @DisplayName("Save student that already exists in repository.")
    @Test
    void saveDuplicateStudentTest() {
        // Implement this
    }

    @DisplayName("When StudentService invokes fetchStudentList(), studentRepository should invoke findAll()")
    @Test
    void fetchStudentListTest() {
        // given
        List<Student> students = Arrays.asList(studentOne);
        // when
        when(studentRepositoryMock.findAll()).thenReturn(students);
        // then
        assertEquals(students, studentServiceTest.fetchStudentList());
        verify(studentRepositoryMock, times(1)).findAll();
    }

    @DisplayName("Fetch existent student by ID")
    @Test
    void fetchStudentByValidIdTest() {
        // when
        when(studentRepositoryMock.findById(1L)).thenReturn(Optional.ofNullable(studentOne));
        // then
        assertEquals(studentOne, studentServiceTest.fetchStudentById(1L));
        verify(studentRepositoryMock, times(2)).findById(1L);
    }

    @DisplayName("Fetch non-existent student by ID")
    @Test
    void fetchStudentByNonExistentIdTest() {
        // when
        doThrow(new StudentNotFoundException("Student ID " + 99L + " does not exist.")).when(studentRepositoryMock).findById(99L);
        // then
        assertThrows(StudentNotFoundException.class, () -> studentServiceTest.fetchStudentById(99L));
        verify(studentRepositoryMock, times(1)).findById(99L);
    }

    @DisplayName("Fetch all students by first name regardless of case")
    @Test
    void fetchStudentByValidFirstName() {
        // given
        List<Student> studentsNamedFrenchFries = Arrays.asList(studentOne, studentThree);
        // when
        when(studentRepositoryMock.findByFirstNameIgnoreCase("fReNcH FrIEs")).thenReturn(studentsNamedFrenchFries);
        // then
        assertEquals(studentsNamedFrenchFries, studentServiceTest.fetchAllStudentsByFirstName("fReNcH FrIEs"));
        verify(studentRepositoryMock, times(1)).findByFirstNameIgnoreCase("fReNcH FrIEs");
    }
}