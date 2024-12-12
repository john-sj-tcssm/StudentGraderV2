package com.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import io.github.cdimascio.dotenv.Dotenv;


public class StudentDatabaseCursor {

    private String dbStringURL;
    private String dbUser;
    private String dbPassword;
    private Statement statement;

    public StudentDatabaseCursor()
    {
        Dotenv dotenv = Dotenv.load();
        this.dbStringURL = dotenv.get("DB_URL");
        this.dbUser = dotenv.get("DB_USER");
        this.dbPassword = dotenv.get("DB_PASSWORD");

        // try-catch with resources, this eliminates the need for manually closing the resource and helps prevent resource leaks.
        try (Connection connection = DriverManager.getConnection(dbStringURL, dbUser, dbPassword))
        {
            connection.setAutoCommit(true); // by default, but ensures any writes onto the database persists and is commited.
            this.statement = connection.createStatement();
        } catch (SQLException e)
        {
            System.out.println("Database connection failed!");
            e.printStackTrace();
        }
    }

    /*
     * TODO: Import Student.java
     * 1) Create Insert Statement given a student
     * 2) Create Select Statement to return Students based on class
     * 3) Create Update Statement given a student_id
     */

    public boolean insertStudent(Student student)
    {
        String studentInsertStatement = "INSERT INTO students (student_id, first_name, last_name, class_name, gpa) VALUES (%d, '%s', '%s', '%s', '%f')";

        try (PreparedStatement preparedStatement = this.statement.getConnection().prepareStatement(studentInsertStatement)) {
            // Use the student object's methods to get the appropriate information. studentId, firstName, lastName, className, and gpa in that exact order.
            preparedStatement.setInt(1, student.getStudentId());
            preparedStatement.setString(2, student.getFirstName());
            preparedStatement.setString(3, student.getLastName());
            preparedStatement.setString(4, student.getClassName());
            preparedStatement.setDouble(5, student.getGpa());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Failed to insert student!");
            e.printStackTrace();
            return false;
        }

        //System.out.println(studentInsertStatement); // DELETE AFTER COMPLETING CODE ABOVE.
        //return false; // DELETE AFTER COMPLETING CODE ABOVE.
    }

    /*
     * TODO: Use these once above method has been implemented.
     */
    public ResultSet getStudentsByClass(String className) {
        String studentSelectByClassName = "SELECT * FROM students WHERE class_name = ?";

        try (PreparedStatement preparedStatement = this.statement.getConnection().prepareStatement(studentSelectByClassName)) {
            preparedStatement.setString(1, className);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            System.out.println("Failed to retrieve students!");
            e.printStackTrace();
            return null;
        }
    }

    public boolean updateStudentClass(int student_id, String class_name)
    {
        String studentUpdateClassByStudentId = "UPDATE students SET class_name = ? WHERE student_id = ?";

        try (PreparedStatement preparedStatement = this.statement.getConnection().prepareStatement(studentUpdateClassByStudentId)) {
            preparedStatement.setString(1, class_name);
            preparedStatement.setInt(2, student_id);
            return preparedStatement.executeUpdate() > 0;
        } catch(SQLException e) {
            System.out.println("Failed to update student's class given an id and a class name");
            e.printStackTrace();
            return false;
        }
    }

}
