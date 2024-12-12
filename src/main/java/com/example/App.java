package com.example;
import java.util.ArrayList;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }
    public static void main(String[] args) {
        Student[] students = Student.studentGenerator();
        for(int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
    }
}
    

