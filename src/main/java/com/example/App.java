package com.example;
import java.util.ArrayList;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        for(int i = 0; i<10; i++){
            students.add(new Student());
        }
    }
}
