package org.example;

import java.time.LocalDate;

public class Student {
    protected String firstName;
    protected String lastName;
    protected LocalDate dateOfBirth;
    protected String gender;
    protected Integer ID;

    public Student(String firstName, String lastName, LocalDate dateOfBirth, String gender, Integer ID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", ID='" + ID + '\'' +
                '}';
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}
