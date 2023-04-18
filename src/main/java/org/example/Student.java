package org.example;

public class Student {
    protected String firstName;
    protected String lastName;
    protected String dateOfBirth;
    protected String gender;
    protected Integer ID;

    public Student(String firstName, String lastName, String dateOfBirth, String gender, Integer ID) {
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
}
