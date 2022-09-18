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
import org.mockito.Mockito;
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

    private Student dummyStudentOne;
    private Student dummyStudentTwo;
    private Student dummyStudentThree;

    @BeforeEach
    void setUp() {
        dummyStudentOne = Student.builder()
                .studentId(1L)
                .firstName("French Fries")
                .lastName("McGovern")
                .faculty(Faculty.BUSINESS)
                .build();

        dummyStudentTwo = Student.builder()
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
        when(studentRepositoryMock.save(dummyStudentOne)).thenReturn(dummyStudentOne);
        // then
        assertEquals(dummyStudentOne, studentServiceTest.saveStudent(dummyStudentOne));
        verify(studentRepositoryMock).save(dummyStudentOne);
        verify(studentRepositoryMock, times(1)).save(dummyStudentOne);
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
        List<Student> students = Arrays.asList(dummyStudentOne);
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
        when(studentRepositoryMock.findById(1L)).thenReturn(Optional.ofNullable(dummyStudentOne));
        // then
        assertEquals(dummyStudentOne, studentServiceTest.fetchStudentById(1L));
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
        List<Student> studentsNamedFrenchFries = Arrays.asList(dummyStudentOne, dummyStudentTwo);
        // when
        when(studentRepositoryMock.findByFirstNameIgnoreCase("fReNcH FrIEs")).thenReturn(studentsNamedFrenchFries);
        // then
        assertEquals(studentsNamedFrenchFries, studentServiceTest.fetchAllStudentsByFirstName("fReNcH FrIEs"));
        verify(studentRepositoryMock, times(1)).findByFirstNameIgnoreCase("fReNcH FrIEs");
    }

    @DisplayName("Run updateStudentById() to update all student fields.")
    @Test
    void updateValidStudentById() {
        // given
        dummyStudentThree = Student.builder()
                .studentId(1L)
                .firstName("Barry")
                .lastName("Popper")
                .faculty(Faculty.MEDICINE)
                .build();
        // when
        when(studentRepositoryMock.findById(1L)).thenReturn(Optional.ofNullable(dummyStudentOne));
        when(studentRepositoryMock.save(Mockito.any())).thenReturn(dummyStudentThree);
        // then
        assertEquals(dummyStudentThree, studentServiceTest.updateStudentById(1L, dummyStudentThree));
        verify(studentRepositoryMock, times(1)).save(Mockito.any());
    }

    @DisplayName("Run updateStudentById() but cannot find student ID")
    @Test
    void updateMissingStudent() {
        // when
        doThrow(new StudentNotFoundException("Student ID " + 99L + " does not exist.")).when(studentRepositoryMock).findById(99L);
        // then
        assertThrows(StudentNotFoundException.class, () -> studentServiceTest.fetchStudentById(99L));
        verify(studentRepositoryMock, times(1)).findById(99L);
        verify(studentRepositoryMock, times(0)).save(Mockito.any());
    }

    @DisplayName("Run updateStudentById() but only first name is provided")
    @Test
    void updateStudentFirstNameOnly() {
        // given
        dummyStudentThree = Student.builder()
                .studentId(1L)
                .firstName("Barry")
                .build();

        // when
        when(studentRepositoryMock.findById(1L)).thenReturn(Optional.ofNullable(dummyStudentOne));
        when(studentRepositoryMock.save(Mockito.any())).thenReturn(dummyStudentThree);
        Student resultStudent = studentServiceTest.updateStudentById(1L, dummyStudentThree);

        // then
        assertEquals(dummyStudentThree.getFirstName(), resultStudent.getFirstName());
        assertEquals(dummyStudentThree.getLastName(), resultStudent.getLastName());
        assertEquals(dummyStudentThree.getFaculty(), resultStudent.getFaculty());
        verify(studentRepositoryMock, times(1)).save(Mockito.any());
    }

    @DisplayName("Run updateStudentById() but only last name is provided")
    @Test
    void updateStudentLastNameOnly() {
        // given
        dummyStudentThree = Student.builder()
                .studentId(1L)
                .lastName("Popper")
                .build();

        // when
        when(studentRepositoryMock.findById(1L)).thenReturn(Optional.ofNullable(dummyStudentOne));
        when(studentRepositoryMock.save(Mockito.any())).thenReturn(dummyStudentThree);
        Student resultStudent = studentServiceTest.updateStudentById(1L, dummyStudentThree);

        // then
        assertEquals(dummyStudentThree.getFirstName(), resultStudent.getFirstName());
        assertEquals(dummyStudentThree.getLastName(), resultStudent.getLastName());
        assertEquals(dummyStudentThree.getFaculty(), resultStudent.getFaculty());
        verify(studentRepositoryMock, times(1)).save(Mockito.any());
    }

    @DisplayName("Run updateStudentById() but only first name is provided")
    @Test
    void updateStudentFacultyOnly() {
        // given
        dummyStudentThree = Student.builder()
                .studentId(1L)
                .faculty(Faculty.MEDICINE)
                .build();

        // when
        when(studentRepositoryMock.findById(1L)).thenReturn(Optional.ofNullable(dummyStudentOne));
        when(studentRepositoryMock.save(Mockito.any())).thenReturn(dummyStudentThree);
        Student resultStudent = studentServiceTest.updateStudentById(1L, dummyStudentThree);

        // then
        assertEquals(dummyStudentThree.getFirstName(), resultStudent.getFirstName());
        assertEquals(dummyStudentThree.getLastName(), resultStudent.getLastName());
        assertEquals(dummyStudentThree.getFaculty(), resultStudent.getFaculty());
        verify(studentRepositoryMock, times(1)).save(Mockito.any());
    }
}