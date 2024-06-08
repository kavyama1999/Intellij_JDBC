package com.xworkz.CreateStatementQueries;

import java.sql.DriverManager;
import java.sql.SQLException;

public class PracticeInserting {

    public static void main(String[] args) {


        try {
            System.out.println("load and register Driver");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("next");

        } catch (ClassNotFoundException e) {
            System.out.println("after");
            throw new RuntimeException(e);
            //System.out.println("hfggjhgjhj");
        }



        String jdbcurl="jdbc:mysql://localhost:3306/metro";
        String username="root";
        String password="Xworkzodc@123";

        try {
            DriverManager.getConnection(jdbcurl,username,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }







//for fecting we can use





    }
}
