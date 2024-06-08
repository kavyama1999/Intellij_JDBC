package com.xworkz.dto;

import java.sql.*;

public class PreparedStatementInsertDataDTO {

    public static void main(String[] args) {

        MetroDTO metroDto=new MetroDTO();

        metroDto.setId(111);
        metroDto.setName("Yellowline");
        metroDto.setSource("Tifactory");
        metroDto.setDestination("k rpuram");
        metroDto.setState("Karnataka");

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

        String preparedQuery="INSERT INTO nammametro (id,name,source,destination,state) values(?,?,?,?,?)";



        try {
            System.out.println("Insert Data using Dto and preparedStatement");
     Connection connection= DriverManager.getConnection(jdbcurl,userName,password);
      PreparedStatement preparedStatement= connection.prepareStatement(preparedQuery);
      //for(MetroDTO dto:)
      preparedStatement.setInt(1,metroDto.getId());
      preparedStatement.setString(2,metroDto.getName());
      preparedStatement.setString(3,metroDto.getSource());
      preparedStatement.setString(4,metroDto.getDestination());
      preparedStatement.setString(5,metroDto.getState());
  boolean result=    preparedStatement.execute();
            System.out.println(result);




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

        }
            System.out.println("Connection is closed");

            try {
                if(statement1!=null)
                statement1.close();
                System.out.println("Statement is closed");


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

