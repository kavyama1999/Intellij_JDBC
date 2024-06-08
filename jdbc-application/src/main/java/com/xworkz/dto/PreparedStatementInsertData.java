package com.xworkz.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementInsertData {

    public static void main(String[] args) {


        System.out.println("load and register driver");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("get connection from database");

        String jdbcurl="jdbc:mysql://localhost:3306/metro";
        String userName="root";
        String password="Xworkzodc@123";

//        id,name,source,destination,state
        String insertDataQuery="INSERT INTO nammametro(id,name,source,destination,state,salary)VALUES(?,?,?,?,?,?)";
        Connection connection1=null;
        PreparedStatement PreparedStatement1=null;

        try {
            Connection connection= DriverManager.getConnection(jdbcurl,userName,password);
            System.out.println("create statement");
            PreparedStatement preparedStatement= connection.prepareStatement(insertDataQuery);
            System.out.println("execute the sql query");

            preparedStatement.setInt(1,90);
            preparedStatement.setString(2,"Blueline");
            preparedStatement.setString(3,"tinfactory");
            preparedStatement.setString(4,"micolayout");
            preparedStatement.setString(5,"karnataka");
            preparedStatement.setInt(6,85000);
            preparedStatement.addBatch();

            preparedStatement.setInt(1,91);
            preparedStatement.setString(2,"green line");
            preparedStatement.setString(3,"banashamkari");
            preparedStatement.setString(4,"kengeri");
            preparedStatement.setString(5,"karnataka");
            preparedStatement.setInt(6,52000);

            preparedStatement.addBatch();

            preparedStatement.setInt(1,92);
            preparedStatement.setString(2,"red line");
            preparedStatement.setString(3,"vijayanagar");
            preparedStatement.setString(4,"jayanagar");
            preparedStatement.setString(5,"karnataka");
            preparedStatement.setInt(6,28000);

            preparedStatement.addBatch();

            preparedStatement.setInt(1,93);
            preparedStatement.setString(2,"blue line ");
            preparedStatement.setString(3,"rajajinagar");
            preparedStatement.setString(4,"basavanagudi");
            preparedStatement.setString(5,"karnataka");
            preparedStatement.setInt(6,40000);

            preparedStatement.addBatch();

            preparedStatement.setInt(1,94);
            preparedStatement.setString(2,"green line");
            preparedStatement.setString(3,"hebbala");
            preparedStatement.setString(4,"nagavara");
            preparedStatement.setString(5,"karnataka");
            preparedStatement.setInt(6,50000);
            preparedStatement.addBatch();

            preparedStatement.executeBatch();
            preparedStatement.executeLargeBatch();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        finally {
            try {
                System.out.println("connection are closed");
                if(connection1!=null)
                    connection1.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                System.out.println("statement closed");
                if(PreparedStatement1!=null)
                    PreparedStatement1.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
