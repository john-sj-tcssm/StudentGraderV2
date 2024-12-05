package com.example;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        for(int i = 0; i<10; i++){
            Student student = new Student();
            System.out.println(student);
        }
    
        

    }
}
