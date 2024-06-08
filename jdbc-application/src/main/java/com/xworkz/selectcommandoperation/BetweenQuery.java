package com.xworkz.selectcommandoperation;

import java.sql.*;

public class BetweenQuery {
    public static void main(String[] args) {


        System.out.println("load and register Driver");



        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection1 = null;
        Statement statement1=null;

        String jdbcurl="jdbc:mysql://localhost:3306/metro";
        String userName="root";
        String password="Xworkzodc@123";

        System.out.println("Between Query");
        String betweenQuery = "SELECT * FROM nammametro WHERE salary BETWEEN 20000  AND 50000";

        try {
            Connection connection= DriverManager.getConnection(jdbcurl,userName,password);
            System.out.println("connection is established");

            Statement statement= connection.createStatement();
            System.out.println("executing query");


            ResultSet resultSet=statement.executeQuery(betweenQuery);
            System.out.println(resultSet);
            //to print all
            while (resultSet.next())
            {
                System.out.println(" salary Between 20000 and 50000 :"+resultSet.getInt("salary"));
            }


        }

        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        finally {
            try {
                if(connection1!=null)
                    connection1.close();
            } catch (SQLException e)
            {
                throw new RuntimeException(e);
            }
        }


        try
        {
            if (statement1 != null)
                statement1.close();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }



}


