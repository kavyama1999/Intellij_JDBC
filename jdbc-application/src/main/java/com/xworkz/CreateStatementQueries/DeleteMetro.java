package com.xworkz.CreateStatementQueries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteMetro {


    public static void main(String[] args) {


        System.out.println("delete query");
        String deletequery = "DELETE from nammametro where id=10";
        String deletequery1 = "DELETE from nammametro where id=5";

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
         Connection connection= DriverManager.getConnection(jdbcurl,userName,password);
         System.out.println("connection is established");

       Statement statement= connection.createStatement();
         System.out.println("executing query");

        boolean result= statement.execute(deletequery);
            System.out.println(result);
            boolean result1=statement.execute(deletequery1);
            System.out.println(result1);


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

