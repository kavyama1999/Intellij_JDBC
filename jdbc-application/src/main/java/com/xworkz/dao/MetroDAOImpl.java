package com.xworkz.dao;

import java.sql.*;
import java.util.Queue;

public class MetroDAOImpl implements MetroDAO {


    //here we can write data base logic ..then main method we can call method creating an object
    @Override
    public void insert() {

        System.out.println("load and register Driver");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        //declared in outside try..othewise it will show scope of error
        Connection connection1 = null;
        Statement statement1 = null;

        System.out.println("get connection from database");

        String jdbcurl = "jdbc:mysql://localhost:3306/metro";
        String userName = "root";
        String password = "Xworkzodc@123";

        String insertData = "INSERT INTO nammametro(id,name,source,destination,state)VALUES(130,'blue line','tinfactory','whitefield','karnataka')";
        try {
            Connection connection = DriverManager.getConnection(jdbcurl, userName, password);
            System.out.println("create statement");
            Statement statement = connection.createStatement();
            System.out.println("execute the sql queries");
            boolean result = statement.execute(insertData);
            System.out.println(result);

            System.out.println("process th resultant data");
            System.out.println("close the costly resources");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                System.out.println("connection closed");
                if (connection1 != null)
                    connection1.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                System.out.println("statement closed");
                if (statement1 != null)
                    statement1.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }





    @Override
    public void delete() {

        System.out.println("load and register Driver");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        //declared in outside try..othewise it will show scope of error
        Connection connection1 = null;
        Statement statement1 = null;

        System.out.println("get connection from database");

        String jdbcurl = "jdbc:mysql://localhost:3306/metro";
        String userName = "root";
        String password = "Xworkzodc@123";

        String deleteDataQueey = "DELETE FROM nammametro where id=129";
        try {
            Connection connection = DriverManager.getConnection(jdbcurl, userName, password);
            System.out.println("create statement");
            Statement statement = connection.createStatement();
            System.out.println("execute the sql queries");
            boolean result = statement.execute(deleteDataQueey);
            System.out.println(result);

            System.out.println("process th resultant data");
            System.out.println("close the costly resources");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                System.out.println("connection closed");
                if (connection1 != null)
                    connection1.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                System.out.println("statement closed");
                if (statement1 != null)
                    statement1.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    }

    @Override
    public void update() {

        System.out.println("load and register Driver");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        //declared in outside try..othewise it will show scope of error
        Connection connection1 = null;
        Statement statement1 = null;

        System.out.println("get connection from database");

        String jdbcurl = "jdbc:mysql://localhost:3306/metro";
        String userName = "root";
        String password = "Xworkzodc@123";

        String updateQuery = "UPDATE nammametro set destination='shivamogga' where id=128";
        try {
            Connection connection = DriverManager.getConnection(jdbcurl, userName, password);
            System.out.println("create statement");
            Statement statement = connection.createStatement();
            System.out.println("execute the sql queries");
            boolean result = statement.execute(updateQuery);
            System.out.println(result);

            System.out.println("process th resultant data");
            System.out.println("close the costly resources");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                System.out.println("connection closed");
                if (connection1 != null)
                    connection1.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                System.out.println("statement closed");
                if (statement1 != null)
                    statement1.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }



    }

    @Override
    public void fetch() {

        System.out.println("load and register Driver");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        //declared in outside try..othewise it will show scope of error
        Connection connection1 = null;
        Statement statement1 = null;

        System.out.println("get connection from database");

        String jdbcurl = "jdbc:mysql://localhost:3306/metro";
        String userName = "root";
        String password = "Xworkzodc@123";

        //String fetchDataQuery = "SELECT * FROM nammametro";//fetch all data
        String fetchDataQuery = "SELECT * FROM nammametro where destination='Tinfactory'";//fetch perticular data

        try {
            Connection connection = DriverManager.getConnection(jdbcurl, userName, password);
            System.out.println("create statement");
            Statement statement = connection.createStatement();
            System.out.println("execute the sql queries");
          ResultSet resultSet= statement.executeQuery(fetchDataQuery);
            System.out.println(resultSet);

            while (resultSet.next())
            {
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getString("source"));
                System.out.println(resultSet.getString("destination"));
                System.out.println(resultSet.getString("state"));
            }

            System.out.println("process th resultant data");
            System.out.println("close the costly resources");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                System.out.println("connection closed");
                if (connection1 != null)
                    connection1.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                System.out.println("statement closed");
                if (statement1 != null)
                    statement1.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    }

}


