package org.example;

import org.junit.jupiter.api.Test;

import java.time.DateTimeException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {
    @Test
    void addingNullAsStudentWillThrowException(){
        StudentRepository repository = new StudentRepository();
        assertThrows(NullPointerException.class,()->repository.addStudent(null));
    }
    @Test
    void happyFlowAddingAStudent(){
        StudentRepository repository = new StudentRepository();
        Student student1 = new Student("Mike","Tyson", LocalDate.parse("1985-05-15"),
                        "M",11);
        repository.addStudent(student1);
        assertFalse(repository.studentList.isEmpty());
    }
    @Test
    void happyFlowAddingTwoStudents(){
        StudentRepository repository = new StudentRepository();
        Student student1 = new Student("Mike","Tyson", LocalDate.parse("1966-05-15"),
                "M",11);
        Student student2 = new Student("Halle","Berry",LocalDate.parse("1966-08-17"),
                "m",22);
        repository.addStudent(student1);
        repository.addStudent(student2);
        assertEquals(repository.studentList.size(),2);
    }
    @Test
    void incorrectNameValidationThrowsException(){
        StudentRepository repository = new StudentRepository();
        Student student1 = new Student("M","Tyson", LocalDate.parse("1966-05-15"),
                "M",11);
        assertThrows(IllegalArgumentException.class,()->repository.addStudent(student1),"Invalid first/last name. " +
                "Name should have at least three characters in order to be valid.");
    }
    @Test
    void incorrectDateOfBirthValidationThrowsException(){
        StudentRepository repository = new StudentRepository();
        Student student1 = new Student("Michael","Tyson", LocalDate.parse("1899-05-15"),
                "M",11);
        assertThrows(DateTimeException.class,()->repository.addStudent(student1),"Student date of birth is not valid. " +
                "Student DOB must be between 1900-01-01 & 2023-04-25");
    }
    @Test
    void incorrectGenderValidationThrowsException(){
        StudentRepository repository = new StudentRepository();
        Student student1 = new Student("Michael","Tyson", LocalDate.parse("1899-05-15"),
                "A",11);
        assertThrows(IllegalArgumentException.class,()->repository.addStudent(student1),"Gender input is not valid. " +
                "Please enter Student gender, M for male / F for female");
    }
    @Test
    void gettingStudentsByAge(){
        StudentRepository repository = new StudentRepository();
        Student student1 = new Student("Mike","Tyson", LocalDate.parse("1989-05-15"),
                "M",11);
        Student student2 = new Student("Halle","Berry",LocalDate.parse("1966-08-17"),
                "m",22);
        Student student3 = new Student("Aleksandr","Usyk",LocalDate.parse("1989-10-12"),
                "m",22);
        repository.addStudent(student1);
        repository.addStudent(student2);
        repository.addStudent(student3);
        assertEquals(student2, repository.retrieveStudent(57));
    }

}