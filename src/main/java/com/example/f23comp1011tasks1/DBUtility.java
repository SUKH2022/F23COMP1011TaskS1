package com.example.f23comp1011tasks1;

public class DBUtility {
    private static String user="root";
    private static String password="Student";
//the java database management
            /***
             * jdbc:mysql -> the database driver
             * 127.0.0.1-> IP address of teh database server
             * 3306-> port number of the database server
             * COMP1011Friday-> name of the database
             */
    private static String connectURL= "jdbc:mysql//127.0.0.1:3306/COMP1011Friday";
}
