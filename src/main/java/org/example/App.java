package org.example;


import java.time.LocalDate;

public class App
{
    public static void main( String[] args ) {

        StudentRepository studentRepository = new StudentRepository();

        Student student1 = new Student("Bruce","Banner", LocalDate.parse("1991-05-10"),
                "M",11);
        Student student2 = new Student("Nick","Furry",LocalDate.parse("1985-08-17"),
                "m",22);

        studentRepository.addStudent(student1);
        studentRepository.addStudent(student2);
        studentRepository.listAllStudentsByLastName();
        studentRepository.listAllStudentsByDateOfBirth();
    }
}
