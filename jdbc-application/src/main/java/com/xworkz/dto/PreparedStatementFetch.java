package com.xworkz.dto;

import java.sql.*;

public class PreparedStatementFetch {

//ctl+Alt+L
    public static void main(String[] args) {


        System.out.println("Load and Register Driver");

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("getting connection from database");

        String jdbcurl = "jdbc:mysql://localhost:3306/metro";
        String userName = "root";
        String password = "Xworkzodc@123";

        String fetchQuery="SELECT * FROM nammametro where name=?";

        Connection connection1=null;
        Statement statement1=null;
        try {
          Connection connection= DriverManager.getConnection(jdbcurl,userName,password);
       PreparedStatement preparedStatement=connection.prepareStatement(fetchQuery);
       //ResultSet resultSet= preparedStatement.executeQuery();//exceute..Query
           // System.out.println(resultSet);
            preparedStatement.setString(1,"Greenline");
            preparedStatement.setString(1,"Yellowline");
            ResultSet resultSet= preparedStatement.executeQuery();//exceute..exceuteQuery


            System.out.println("print all greenline data");

            while (resultSet.next())
            {

                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getString("source"));
                System.out.println(resultSet.getString("destination"));
                System.out.println(resultSet.getString("state"));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        finally {

            try {
                if(connection1!=null)
                connection1.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


            try {

                if(statement1!=null)
                statement1.close();
                System.out.println("Statement is closed");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
