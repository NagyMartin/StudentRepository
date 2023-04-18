package org.example;


import java.util.HashMap;
import java.util.Scanner;


public class StudentRepository {
    HashMap<Integer, Student> studentRepository = new HashMap<>();

    Student createStudent(){
        boolean IdValidation = false;
        boolean firstNameValidation = false;
        boolean lastNameValidation = false;
        boolean genderValidation = false;
        String genderInput;
        Student createdStudent = new Student("a","b","c","d",0);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter Student first name: ");
        while(!firstNameValidation){
            try{
                createdStudent.firstName = scanner.nextLine();
                firstNameValidation = true;
            } catch(NullPointerException npe){
                System.out.println("First name should not be left empty. Please try again.");
            }
        }

        System.out.println("Please enter Student last name: ");
        while(!lastNameValidation){
            try{
                createdStudent.lastName = scanner.nextLine();
                lastNameValidation = true;
            } catch(NullPointerException npe){
                System.out.println("Last name should not be left empty. Please try again.");
            }
        }
        System.out.println("Please enter Student date of birth: ");
        createdStudent.dateOfBirth = scanner.nextLine();
        System.out.println("Please enter Student gender, M for male / F for female: ");
        while(!genderValidation){
            try{
                genderInput = scanner.nextLine();
                switch (genderInput) {
                    case "M", "F" -> {
                        genderValidation = true;
                    }
                    default -> System.out.println("Please enter a valid gender type.");
                }
            } catch(NullPointerException npe){
                System.out.println("Gender should not be left empty. Please try again.");
            }
        }
        System.out.println("Please enter Student ID: ");
        while(!IdValidation) {
            try {
                createdStudent.ID = Integer.parseInt(scanner.nextLine());
                IdValidation = true;
            } catch (NumberFormatException | NullPointerException nfpe) {
                System.out.println("Error, please enter a number based ID.");
            }
        }
        return createdStudent;
    }
    void addStudent(Student student){
        if(student == null){
            System.out.println("Student has to have all fields completed in order to add to the repository.");
            return;
        }
        try{
        studentRepository.put(student.ID, student);
        System.out.println("Student is being added to the repository.");
        }
        catch (RuntimeException iae){
            System.out.println("The ID you have entered is not valid. Please enter only digits for the ID field.");
        }
    }
    void deleteStudent(Integer studentID){
        if(studentRepository.containsKey(studentID)){
            studentRepository.remove(studentID);
            System.out.println("The student with the following ID: " + studentID + " is removed.");
        }
    }
    void retrieveStudent(){

    }
    void listAllStudents(){

    }

}
