package com.xworkz.dto;

import java.sql.*;

public class UpdateDataDTO {

    public static void main(String[] args) {

        Connection connection1=null;
        Statement statement1=null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String jdbcurl="jdbc:mysql://localhost:3306/metro";
        String userName="root";
        String password="Xworkzodc@123";
        String updateQuery = "UPDATE nammametro SET source = ? WHERE id = ?";//based number of parameters
        String updateQuery1= "UPDATE nammametro SET destination = ? WHERE id = ?";//based number of parameters


        try {
            System.out.println("Update Data using Dto and preparedStatement");
   Connection connection  =  DriverManager.getConnection(jdbcurl,userName,password);
  PreparedStatement preparedStatement= connection.prepareStatement(updateQuery);
  preparedStatement.setString(1, "kengeri");
  preparedStatement.setInt(2,103);
            preparedStatement.execute();

            //2nd update
            System.out.println("2nd update");
            PreparedStatement preparedStatement1= connection.prepareStatement(updateQuery1);
            preparedStatement1.setString(1,"Banasahakari");
            preparedStatement1.setInt(2,104);
            preparedStatement1.execute();



            //preparedStatement.execute();


        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
finally {
            try {
                if(connection1!=null)
                connection1.close();
                System.out.println("Connection is closed");

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
