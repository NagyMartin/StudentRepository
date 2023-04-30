package org.example;
/**
 * Repository class that contains methods that add, delete, list students based on last name/D.O.B.
 * and retrieve a student/s based on age.
 * For the add method, there are some validations if not met, then some exceptions are thrown.
 */

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.*;


public class StudentRepository {
    protected List<Student> studentList = new ArrayList<>();

    void addStudent(Student student) {
        if (!student.fullNameValidation()) {
            throw new IllegalArgumentException("Invalid first/last name. " +
                    "Name should have at least three characters in order to be valid.");
        }
        if (!student.dateOfBirthValidation()) {
            throw new DateTimeException("Student date of birth is not valid. " +
                    "Student DOB must be between 1900-01-01 & 2023-04-25");
        }
        if (!student.genderValidation()) {
            throw new IllegalArgumentException("Gender input is not valid. " +
                    "Please enter Student gender, M for male / F for female");
        }
        studentList.add(student);
    }

    void deleteStudent(Integer studentID) {
        if (studentID == null || !studentID.equals(studentList.listIterator().next().ID)) {
            System.out.println("The ID entered must not be null or " +
                    "it is not linked to any student in the repository.");
        } else {
            studentList.removeIf(student -> student.ID.equals(studentID));
            System.out.println("Student is now removed from the repository.");
        }
    }

    Student retrieveStudent(Integer age) {
        Integer yearCheck = LocalDate.now().getYear() - age;
        if (age <= 0) {
            throw new IllegalArgumentException("Age must not be negative.");
        } else {
            for (Student student : studentList) {
                if (student.dateOfBirth.getYear() == yearCheck) {
                    System.out.println("The student " + student.firstName + " "
                            + student.lastName + " has the current age of: " + age);
                    return student;
                } else {
                    System.out.println("There are no/no other students with the requested age of: " + age);
                }
            }
        }
        return null;
    }

    void listAllStudentsByLastName() {
        studentList.sort(new LastNameComparator());
        System.out.println(studentList);
    }

    void listAllStudentsByDateOfBirth() {
        studentList.sort(new BirthDateComparator());
        System.out.println(studentList);
    }

}
