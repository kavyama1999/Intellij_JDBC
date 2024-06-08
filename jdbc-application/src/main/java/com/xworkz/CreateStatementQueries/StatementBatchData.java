package com.xworkz.CreateStatementQueries;

import java.sql.*;

public class StatementBatchData {

    public static void main(String[] args) {
        System.out.println("load and register Driver");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("get connection from database");

        String jdbcurl = "jdbc:mysql://localhost:3306/metro";
        String userName = "root";
        String password = "Xworkzodc@123";

        //add batchdata

        //String insertBatchData="INSERT INTO nammametro(id,name,source,destination,state)VALUES(124,'Greeen line','tinfactory','majestic','karnataka')";
        String updateBatchData = "UPDATE nammametro set destination='mgroad' where id=50";
        String deleteBatchData = "DELETE FROM nammametro where id=13";
        String fetchBatchData = "SELECT * FROM nammametro where name='Yellloline'";

        try {
            Connection connection = DriverManager.getConnection(jdbcurl, userName, password);
            System.out.println("create statement");

            Statement statement = connection.createStatement();
            System.out.println("execute the query");
            //statement.addBatch(insertBatchData);
            statement.addBatch(updateBatchData);
            statement.addBatch(deleteBatchData);
            statement.executeBatch();

            // statement.addBatch(fetchBatchData);
            ResultSet resultSet = statement.executeQuery(fetchBatchData);
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getString("source"));
                System.out.println(resultSet.getString("destination"));
                System.out.println(resultSet.getString("state"));

            }
            //statement.executeBatch();


            System.out.println("execute batch successfull");

//           int[] result= statement.executeBatch();
//            System.out.println(result);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
