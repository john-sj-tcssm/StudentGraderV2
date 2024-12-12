package com.example;
import java.util.ArrayList;
import java.util.Random;


public class Student {
    private String firstName;
    private String lastName;
    private double gpa;
    private String className;
    private int studentId;
    private static int studentCounter;

    private static Random random = new Random();

    public Student(){
        final String[] STUDENT_FIRST_NAMES =
        {
            "John","James","Timmy",
            "Timothy","Teddy","Sally",
            "Jessica","Jimmy",
            "Elizabeth","Charles"
        };

         final String[] STUDENT_LAST_NAMES =
        {
            "Le","Chiang","Smith",
            "Hollingsworth","Felder","Real",
            "Chen","Dartnell","McGarry","Ward"
        };

        final String[] CLASS_NAME = {"Freshman","Sophomore","Junior","Senior"};
        final double[] GPA = {4.0, 3.6, 3.7, 3.5, 2.8, 1.7, 3.1, 2.0, 1.6};

        this.firstName = STUDENT_FIRST_NAMES[random.nextInt(STUDENT_FIRST_NAMES.length)];

        this.lastName = STUDENT_LAST_NAMES[random.nextInt(STUDENT_LAST_NAMES.length)];

        this.gpa = GPA[random.nextInt(GPA.length)];

        this.studentId = studentCounter++;

        this.className = CLASS_NAME[random.nextInt(CLASS_NAME.length)];

        Student student = new Student(this.firstName, this.lastName, this.gpa, this.studentId, this.className);
        


    }



    public Student(String firstName, String lastName, double gpa, int studentId, String className)
    {
            this.firstName = firstName;
            this.lastName = lastName;
            this.gpa = gpa;
            this.studentId = studentId;
            this.className = className;
    }

   public String getFirstName() { return this.firstName; }
   public void setFirstName (String newFirstName) { this.firstName = newFirstName; }
   public String getLastName() { return this.lastName; }
   public void setLastName (String newLastName) { this.lastName = newLastName; }
   public int getStudentId() { return this.studentId; }
   public void setStudentId(int newStudentId) { this.studentId= newStudentId; }
   public double getGpa() { return this.gpa; }
   public void setGpa(float newGpa) { this.gpa= newGpa; }
   public String getClassName() { return this.className; }
   public void setClassName(String newClassName) { this.className= newClassName; }


    /*
     * TODO: Implement this Student class with the following attributes:
     *  - firstName (String)
     *  - lastName (String)
     *  - gpa (float)
     *  - class (String)
     *  - studentId (integer)
     */

    // Create the Student classes, getter and setter methods per attribute.
    // Create a static method that generates 10 students.

    // - HINT: Check StudentSeeder. What data-structures did you need to create in order to generate a single student.
    // Override the toString() to dsiplay a Student's name, class and studentId
    public static Student[] studentGenerator(int numberOfStudents) {

        Student[] students = new Student[numberOfStudents];

        for(int i = 0; i < students.length; i++) {
            students[i] = new Student();
        }
        return students;
        
    }

    public static Student[] studentGenerator() {

        Student[] students = new Student[10];

        for(int i = 0; i < students.length; i++) {
            students[i] = new Student();
        }
        return students;
        
    }



    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.firstName + "," + this.lastName + "," + this.gpa + "," +  this.studentId + "," +  this.className;
    }
}
