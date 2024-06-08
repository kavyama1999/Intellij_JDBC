package com.xworkz.CreateStatementQueries;

import java.sql.*;

//execute ..executeQuery
public class FetchMetroExecute {

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
            ResultSet resultSet= statement.executeQuery(fetchQuery);
            System.out.println(resultSet);//FQN with @the rate of hexadecimal number
            //printing all data
           while(resultSet.next())
           //if(resultSet.next())//it  will print only 1st data
//while and if hakidre it will skip 1st then it will print all remaining elements
            //{
              //  for(int i=1;resultSet.next()==true;i++)//it will print until condition false

                {
                    System.out.println(resultSet.getInt("id"));
                    System.out.println(resultSet.getString("name"));
                    System.out.println(resultSet.getString("source"));
                    System.out.println(resultSet.getString("destination"));
                    System.out.println(resultSet.getString("state"));
                    //System.out.println("Fetch based on column number");
//                    System.out.println(resultSet.getInt(1));//index start with 1
//                    System.out.println(resultSet.getInt(3));
//                    System.out.println(resultSet.getInt(4));


                }


       // }
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

//while(fetch1.next())
//        {
//        //fetch based on index and label also
//
//        System.out.println(fetch1.getInt("id"));
//        System.out.println(fetch1.getString("name"));
//        System.out.println(fetch1.getString("source"));
//        System.out.println(fetch1.getString("destination"));
//        System.out.println(fetch1.getString("state"));
//
//        System.out.println("--------------------------------");
//                System.out.println(fetch1.getInt(1));
//        System.out.println(fetch1.getString(2));
//        System.out.println(fetch1.getString(3));
//        System.out.println(fetch1.getString(4));
//        System.out.println(fetch1.getString(5));
//        }