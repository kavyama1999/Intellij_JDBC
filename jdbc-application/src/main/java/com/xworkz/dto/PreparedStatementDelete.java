package com.xworkz.dto;

import java.sql.*;

public class PreparedStatementDelete {

    public static void main(String[] args) {

        System.out.println("load and register driver");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        String jdbcurl="jdbc:mysql://localhost:3306/metro";
        String username="root";
        String passsword="Xworkzodc@123";

        String deleteQuery="DELETE FROM nammametro  WHERE id=?";

        System.out.println("delete data from nammametro table");
        try {
          Connection connection= DriverManager.getConnection(jdbcurl,username,passsword);
      PreparedStatement preparedStatement= connection.prepareStatement(deleteQuery);
//      preparedStatement.setInt(1,111);
//            preparedStatement.setInt(1,104);
//            preparedStatement.setInt(1,11);
            //preparedStatement.setInt(1,20);
          //  preparedStatement.setInt(1,25);
           // preparedStatement.setInt(1,50);
            //preparedStatement.setInt(1,111);
            preparedStatement.setInt(1,103);




            int result=    preparedStatement.executeUpdate();
            System.out.println(result);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static class PreparedStatementInsert {

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
            System.out.println("Prepared Statement ");

            String query="Insert into nammametro(id,name,source,destination,state) values(?,?,?,?,?)"; //dynamic placeholder



            Connection connection1=null;
            Statement statement1=null;

            try {
                Connection connection= DriverManager.getConnection(jdbcurl,userName,password);
                System.out.println("connection is established");
                System.out.println("preparedStatement insertion");
                PreparedStatement statement= connection.prepareStatement(query);

                //isert data

                statement.setInt(1,13);
                statement.setString(2,"purpleline");
                statement.setString(3,"tinfactory");
                statement.setString(4,"mg road");
                statement.setString(5,"karnataka");
                //statement.execute();
                System.out.println("1.inserted successfully");
                statement.setInt(1,18);
                statement.setString(2,"greenline");
                statement.setString(3,"krpuram");
                statement.setString(4,"hoskote");
                statement.setString(5,"karnataka");
               // statement.execute();
                System.out.println("2.inserted successfully");

                statement.setInt(1,20);
                statement.setString(2,"redline");
                statement.setString(3,"halsur");
                statement.setString(4,"indiranagar");
                statement.setString(5,"karnataka");
                statement.execute();
                System.out.println("3.inserted successfully");

                statement.setInt(1,25);
                statement.setString(2,"greenline");
                statement.setString(3,"whitefield");
                statement.setString(4,"devarabisanahalli");
                statement.setString(5,"karnataka");
                statement.execute();
                System.out.println("4.inserted successfully");






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
}
