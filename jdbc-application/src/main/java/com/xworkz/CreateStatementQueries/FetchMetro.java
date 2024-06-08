package com.xworkz.CreateStatementQueries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchMetro {
    public static void main(String[] args) {


        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }



        String jdbcurl="jdbc:mysql://localhost:3306/metro";
        String userName="root";
        String password="Xworkzodc@123";
        //
        System.out.println("read query");

        String fetchQuery="SELECT * FROM nammametro";

        Connection connection1=null;
        Statement statement1=null;

        try {
      Connection connection= DriverManager.getConnection(jdbcurl,userName,password);
            System.out.println("connection is established");

            Statement statement= connection.createStatement();
            System.out.println("Execute query");
      boolean result= statement.execute(fetchQuery);
            System.out.println(result);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

finally {
            try {
                if(connection1!=null)
                connection1.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            System.out.println("connection closed");
        }


        try {
            if(statement1!=null)
            statement1.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Statement is closed");

    }
}
