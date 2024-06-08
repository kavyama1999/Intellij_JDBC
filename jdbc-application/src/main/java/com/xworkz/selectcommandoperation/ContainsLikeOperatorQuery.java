package com.xworkz.selectcommandoperation;

import java.sql.*;

public class ContainsLikeOperatorQuery {

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

        System.out.println("Contains Like Query");
//        The CONTAINS function is not a standard SQL function for MySQL. Instead, you should use the LIKE operator to check if a column contains a specific substring.
//        String likeOperatorQuery = "SELECT * FROM nammametro WHERE CONTAINS(source,'tinfactory')";
        String likeOperatorQuery = "SELECT * FROM nammametro WHERE source   LIKE '%tinfactory%'";
        String likeOperatorQuery1="SELECT * FROM nammametro WHERE destination LIKE 'k%'";

        try {
            Connection connection= DriverManager.getConnection(jdbcurl,userName,password);
            System.out.println("connection is established");

            Statement statement= connection.createStatement();
            System.out.println("executing query");


            ResultSet resultSet=statement.executeQuery(likeOperatorQuery);
            System.out.println(resultSet);

            Statement statement2= connection.createStatement();

            ResultSet resultSet1=statement2.executeQuery(likeOperatorQuery1);
            System.out.println(resultSet1);

            //to print all
            while(resultSet.next())
            {
                System.out.println(" Source column contains Tinfactory are :"+resultSet.getString("source"));
            }
            while(resultSet1.next())
            {
                System.out.println("Destination name start with 'k' are:"+resultSet1.getString("destination"));
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
