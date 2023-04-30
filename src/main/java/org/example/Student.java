package org.example;
/**
 * Class that contains the student object, constructor, getter methods and validations checks.
 */

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

    boolean fullNameValidation() {
        return firstName.length() >= 3 && lastName.length() >= 3;
    }

    boolean dateOfBirthValidation() {
        return dateOfBirth.isAfter(LocalDate.parse("1900-01-01")) ||
                dateOfBirth.isBefore(LocalDate.parse("2023-04-25"));
    }

    boolean genderValidation() {
        return gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("F");
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
