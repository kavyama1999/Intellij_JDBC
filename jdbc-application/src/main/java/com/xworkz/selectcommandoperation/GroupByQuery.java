package com.xworkz.selectcommandoperation;

import java.sql.*;

public class GroupByQuery {

    public static void main(String[] args) {

        System.out.println("GroupBy Query");
//        String groupByQuery = "SELECT COUNT(state),name from nammametro GROUP BY name";

        //String groupByQuery = "SELECT COUNT(state) AS state_count, name FROM nammametro WHERE id BETWEEN 50 AND 100 GROUP BY name";
        String groupByQuery = "SELECT COUNT(id), name FROM nammametro GROUP BY name";

        Connection connection1 = null;
        Statement statement1 = null;


        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        String jdbcurl = "jdbc:mysql://localhost:3306/metro";
        String userName = "root";
        String password = "Xworkzodc@123";
        try {
            Connection connection = DriverManager.getConnection(jdbcurl, userName, password);
            System.out.println("connection is established");

            Statement statement = connection.createStatement();
            System.out.println("executing query");

            ResultSet resultSet = statement.executeQuery(groupByQuery);
            System.out.println(resultSet);

//while (resultSet.next())
//{
//    System.out.println(resultSet.getInt("Count(id)"));
//    System.out.println(resultSet.getString("name"));
            // Iterate through the result set and print the results

            while (resultSet.next()) {
                int idCount = resultSet.getInt("Count(id)");
                String name = resultSet.getString("name");
                System.out.println("Count(id): " + idCount + ", name: " + name);

            }

        }
//}


        catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (connection1 != null)
                    connection1.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


        try {
            if (statement1 != null)
                statement1.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

