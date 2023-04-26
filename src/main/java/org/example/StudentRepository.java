package org.example;


import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.*;


public class StudentRepository {
    protected HashMap<Integer, Student> studentHashMap = new HashMap<>();

    protected void createStudent() {
        boolean IdValidation = false;
        boolean firstNameValidation = false;
        boolean lastNameValidation = false;
        boolean dateOfBirthValidation = false;
        boolean genderValidation = false;
        String genderInput;
        String dateOfBirthInput;
        Student createdStudent = new Student("a", "b", LocalDate.parse("2000-10-10"), "d", 0);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter Student first name: ");
        while (!firstNameValidation) {
            try {
                createdStudent.firstName = scanner.nextLine();
                if (createdStudent.firstName.length() >= 3) {
                    firstNameValidation = true;
                } else {
                    System.out.println("The first name should have at least three characters in order to be valid.");
                }
            } catch (Exception e) {
                throw new IllegalArgumentException("First name should not be left empty. Please try again.");
            }
        }

        System.out.println("Please enter Student last name: ");
        while (!lastNameValidation) {
            try {
                createdStudent.lastName = scanner.nextLine();
                if (createdStudent.lastName.length() >= 3) {
                    lastNameValidation = true;
                } else {
                    System.out.println("The last name should have at least three characters in order to be valid.");
                }
            } catch (Exception e) {
                throw new IllegalArgumentException("Last name should not be left empty. Please try again.");
            }
        }

        System.out.println("Please enter Student date of birth with the following format yyyy-mm-dd: ");
        dateOfBirthInput = scanner.nextLine();
        while (!dateOfBirthValidation) {
            try {
                createdStudent.dateOfBirth = LocalDate.parse(dateOfBirthInput);
                if (createdStudent.dateOfBirth.isAfter(LocalDate.parse("1900-01-01")) ||
                        createdStudent.dateOfBirth.isBefore(LocalDate.parse("2023-04-25"))) {
                    dateOfBirthValidation = true;
                } else {
                    System.out.println("Student date of birth is not valid. Please retry.");
                }
            } catch (Exception e) {
                throw new DateTimeException("Students DOB must be between 1900-01-01 & 2023-04-25");
            }
        }

        System.out.println("Please enter Student gender, M for male / F for female: ");
        while (!genderValidation) {
            try {
                genderInput = scanner.nextLine();
                switch (genderInput) {
                    case "M", "F" -> {
                        genderValidation = true;
                        createdStudent.gender = genderInput;
                    }
                    default -> System.out.println("Please enter a valid gender type.");
                }
            } catch (Exception e) {
                throw new IllegalArgumentException("Gender should not be left empty. Please try again.");
            }
        }

        System.out.println("Please enter Student ID: ");
        while (!IdValidation) {
            try {
                createdStudent.ID = Integer.parseInt(scanner.nextLine());
                IdValidation = true;
            } catch (NumberFormatException | NullPointerException nfe) {
                throw new IllegalArgumentException("Error, please enter a number based ID.");
            }
        }
        addStudent(createdStudent);
    }

    void addStudent(Student student) {
        try {
            studentHashMap.put(student.ID, student);
            System.out.println("Student is being added to the repository.");
        } catch (RuntimeException iae) {
            System.out.println("The ID you have entered is not valid. Please enter only digits for the ID field.");
        }
    }

    void deleteStudent(Integer studentID) {
        if (studentHashMap.containsKey(studentID)) {
            studentHashMap.remove(studentID);
            System.out.println("The student with the following ID: " + studentID + " is removed.");
        } else if (studentID == null) {
            System.out.println("The ID entered must not be null. Please try again.");
        } else {
            System.out.println("The ID entered is not linked to any student in the repository.");
        }
    }

    void retrieveStudent(Integer age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age must not be negative.");
        }
        try {
            LocalDate currentYear = LocalDate.now();
            studentHashMap.forEach((ID, Student) -> {
                if (Student.dateOfBirth.compareTo(currentYear) == age) {
                    System.out.print("Student " + Student.firstName + " " + Student.lastName +
                            ", with the ID: " + Student.ID + ", has the age of " + age);
                }
            });
        } catch (Exception e) {
            throw new RuntimeException("Age must be a number in order for the search to work." + e.getMessage());
        }

    }

    void listAllStudentsByLastName() {
        List list = new ArrayList<>(studentHashMap.entrySet().stream().toList());
        Collections.sort(list, new LastNameComparator());
        System.out.println(list);
    }

    void listAllStudentsByDateOfBirth() {
        List list = new ArrayList<>(studentHashMap.entrySet().stream().toList());
        Collections.sort(list, new BirthDateComparator());
        System.out.println(list);
    }

}
