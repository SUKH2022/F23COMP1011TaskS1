package com.example.f23comp1011tasks1;

import java.sql.*;

public class DBUtility {
    private static String dbUser="root";
    private static String password="student";
//the java database management
            /***
             * jdbc:mysql -> the database driver
             * 127.0.0.1-> IP address of teh database server
             * 3306-> port number of the database server
             * COMP1011Friday-> name of the database
             */
    private static String connectURL= "jdbc:mysql://localhost:3306/?user=root";

    /***
     * This method will save a user to the database
     */
    public static String saveUserToDB(User user) throws SQLException {
        String responseMsg = "broken";

        String sql ="INSERT INTO users VALUES(?,?)";
//        try()-> is called try with resources
//        anything inside the () will be automatically  closed

        try (
                Connection conn = DriverManager.getConnection(connectURL, dbUser,password);
                PreparedStatement ps =conn.prepareStatement(sql);
                ) {
            //  some code
            //  sanitize the code or protected from attacks
            ps.setString(1,user.getEmail());
            ps.setString(2,user.getUserName());

            ps.executeUpdate();
            responseMsg="User Added";
        }
        //  if the email address was already in the DB, a SQL Integrity Constraint Exception is thrown
        //  and the now user would not be added
        catch (SQLIntegrityConstraintViolationException e) {
            responseMsg="User already defined is DB";
        }
        catch (Exception e){
            responseMsg= e.getMessage();
        }
        return responseMsg;
    }
}
