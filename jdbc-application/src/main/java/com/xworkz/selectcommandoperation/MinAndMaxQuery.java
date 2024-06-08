package com.xworkz.selectcommandoperation;

import java.sql.*;

public class MinAndMaxQuery {

    public static void main(String[] args) {



        System.out.println("min query");
        //String minQuery = "SELECT MIN(salary)  min_salary FROM nammametro";

        String minQuery = "SELECT MIN(salary) AS min_salary FROM nammametro";
        String maxQuery = "SELECT MAX(salary)  FROM nammametro";


        Connection connection1 = null;
        Statement statement1=null;


        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        String jdbcurl="jdbc:mysql://localhost:3306/metro";
        String userName="root";
        String password="Xworkzodc@123";
        try {
            Connection connection = DriverManager.getConnection(jdbcurl, userName, password);
            System.out.println("connection is established");
//minimun
            Statement statement = connection.createStatement();
            System.out.println("executing query");
//maxium
            Statement statement2 = connection.createStatement();
            System.out.println("executing query");

            ResultSet resultSet = statement.executeQuery(minQuery);
            System.out.println(resultSet);

            ResultSet resultSet1 = statement2.executeQuery(maxQuery);
            System.out.println(resultSet1);
            while (resultSet.next()) {

//    System.out.println(resultSet.getInt("salary"));
                System.out.println("Minimum salary: " + resultSet.getInt("min_salary"));
            }

            while (resultSet1.next()) {
                System.out.println("Maximum salary:" + resultSet1.getInt("MAX(salary)"));
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

