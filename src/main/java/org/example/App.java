package org.example;


public class App
{
    public static void main( String[] args ) {

        StudentRepository studentRepository = new StudentRepository();

        studentRepository.createStudent();

        studentRepository.createStudent();

        studentRepository.listAllStudentsByDateOfBirth();

    }
}
