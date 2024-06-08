package com.xworkz.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementBatchInsertData {


    public static void main(String[] args) {


        System.out.println("load and register data");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("get connection from database");
        String jdbcurl="jdbc:mysql://localhost:3306/metro";
        String userName="root";
        String password="Xworkzodc@123";


        String PreparedStatementBatchInsertData="INSERT INTO nammametro(id,name,source,destination,state)VALUES (?,?,?,?,?)";
        try {
       Connection connection= DriverManager.getConnection(jdbcurl,userName,password);
            System.out.println("create preparedStatement");
      PreparedStatement preparedStatement= connection.prepareStatement(PreparedStatementBatchInsertData);
            //connection.setAutoCommit(false);//by default true
            preparedStatement.setInt(1,125);
            preparedStatement.setString(2,"Green line");
            preparedStatement.setString(3,"krpuram");
            preparedStatement.setString(4,"Tinfactory");
            preparedStatement.setString(5,"Karnataka");
            preparedStatement.addBatch();

            preparedStatement.setInt(1,126);
            preparedStatement.setString(2,"Blue line");
            preparedStatement.setString(3,"Mgroad");
            preparedStatement.setString(4,"Vijayanagar");
            preparedStatement.setString(5,"Karnataka");
            preparedStatement.addBatch();

            preparedStatement.executeBatch();
            preparedStatement.executeLargeBatch();// when we have data like 1000,100 then it will work queries


//            connection.setAutocomit(false);//by default true
//
//            connection.commit





        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
