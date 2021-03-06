package com.test.web.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDbUtil {


    public List<Student> getStudents() throws Exception {

        List<Student> students = new ArrayList<>();

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            // get a connection
            Class.forName("com.mysql.jdbc.Driver");
            myConn = DriverManager.getConnection("jdbc:mysql://192.168.1.117:3306/web_student_tracker?useSSL=false",
                    "Cat", "100281");

            // create sql statement
            String sql = "select * from student order by last_name";
            myStmt = myConn.createStatement();

            // execute query
            myRs = myStmt.executeQuery(sql);

            // process result set
            while (myRs.next()) {
                // retrieve data from result set
                int id = myRs.getInt("id");
                String firstName = myRs.getString("first_name");
                String lastName = myRs.getString("last_name");
                String email = myRs.getString("email");

                // Create new student object
                Student tempStudent = new Student(id, firstName, lastName, email);

                // add to list of students
                students.add(tempStudent);
            }

            return students;
        }
        finally {
            // close JDBC objects
            close(myConn, myStmt, myRs);

        }
    }

    private static void close(Connection myConn, Statement myStmt, ResultSet myRs) {
        try {
            if (myRs != null) {
                myRs.close();
            }
            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close(); // not really close, just put back in connection pool.
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void addStudent(Student theStudent) throws Exception{

        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            // db connection
            Class.forName("com.mysql.jdbc.Driver");
            myConn = DriverManager.getConnection("jdbc:mysql://192.168.1.117:3306/web_student_tracker", "Cat", "100281");

            // create sql for insert
            String sql = "insert into student " +
                        "(first_name, last_name, email) " +
                        "value (?, ?, ?)";
            myStmt = myConn.prepareStatement(sql);

            // set the param values for the student
            myStmt.setString(1, theStudent.getFirstName());
            myStmt.setString(2, theStudent.getLastName());
            myStmt.setString(3, theStudent.getEmail());

            // execute sql
            myStmt.execute();
        }
        finally {
            // cleanup jdbc objects
            close(myConn, myStmt, null);
        }
    }

    public Student getStudent(String theStudentId) throws Exception {
        Student theStudent = null;

        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        int studentId;

        try{
            // convert student id to int
            studentId = Integer.parseInt(theStudentId);

            // get connecion to db
            Class.forName("com.mysql.jdbc.Driver");
            myConn = DriverManager.getConnection("jdbc:mysql://192.168.1.117:3306/web_student_tracker", "Cat", "100281");

            // create sql to get selected student
            String sql = "select * from student where id=?";

            // ceate prepared statment
            myStmt = myConn.prepareStatement(sql);

            // set params
            myStmt.setInt(1, studentId);

            // execute statement
            myRs = myStmt.executeQuery();

            // retriefve data from result
            if (myRs.next()) {
                String firstName = myRs.getString("first_name");
                String lastName = myRs.getString("last_name");
                String email = myRs.getString("email");

                theStudent = new Student(studentId, firstName, lastName, email);
            } else {
                throw new Exception("Could not find student id:" + studentId);
            }

            return theStudent;
        }
        finally {
            // clean up JDBC connection
            close(myConn, myStmt, myRs);
        }
    }

    public static void updateStudent(Student theStudent) throws Exception{

        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            // get db connection
            Class.forName("com.mysql.jdbc.Driver");
            myConn = DriverManager.getConnection("jdbc:mysql://192.168.1.117:3306/web_student_tracker", "Cat", "100281");

            // create sql statement
            String sql = "update student " +
                        "set first_name=?, last_name=?, email=? " +
                        "where id=?";

            // prepare statement
            myStmt = myConn.prepareStatement(sql);

            // set params
            myStmt.setString(1, theStudent.getFirstName());
            myStmt.setString(2, theStudent.getLastName());
            myStmt.setString(3, theStudent.getEmail());
            myStmt.setInt(4, theStudent.getId());

            // execute sql statement
            myStmt.execute();
        }
        finally {
            // clean up JDBC connection
            close(myConn, myStmt, null);
        }
    }

    public void deleteStudent(String theStudentId) throws Exception{
        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            // convert studet id to int
            int studentId = Integer.parseInt(theStudentId);

            // get connecton to db
            Class.forName("com.mysql.jdbc.Driver");
            myConn = DriverManager.getConnection("jdbc:mysql://192.168.1.117:3306/web_student_tracker", "Cat", "100281");

            // create sql to delete student
            String sql = "delete from student where id=?";

            // prepare statment
            myStmt = myConn.prepareStatement(sql);

            // set parameters
            myStmt.setInt(1, studentId);

            // executue sql statement
            myStmt.execute();
        }
        finally {
            close(myConn, myStmt, null);
        }
    }
}
