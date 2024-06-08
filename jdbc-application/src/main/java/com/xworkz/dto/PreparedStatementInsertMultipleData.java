package com.xworkz.dto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PreparedStatementInsertMultipleData {

    public static void main(String[] args) {

        MetroDTO metroDTO1=new MetroDTO();

        metroDTO1.setId(102);
        metroDTO1.setName("Blueline");
        metroDTO1.setSource("Halsuru");
        metroDTO1.setDestination("M G road");
        metroDTO1.setState("Karnataka");

        MetroDTO metroDTO2=new MetroDTO();

        metroDTO2.setId(103);
        metroDTO2.setName("Redline");
        metroDTO2.setSource("Vijanagar");
        metroDTO2.setDestination("Tinfactory");
        metroDTO2.setState("Karnataka");

        MetroDTO metroDTO3=new MetroDTO();

        metroDTO3.setId(104);
        metroDTO3.setName("Blueline");
        metroDTO3.setSource("Rajajinagar");
        metroDTO3.setDestination("MicoLayout");
        metroDTO3.setState("Karnataka");
        //we have to create one list

        List<MetroDTO> metroList=new ArrayList<>();

        metroList.add(metroDTO1);
        metroList.add(metroDTO2);
        metroList.add(metroDTO3);


        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String jdbcurl="jdbc:mysql://localhost:3306/metro";
        String userName="root";
        String password="Xworkzodc@123";

        String preparedQuery="INSERT INTO nammametro(id,name,source,destination,state) values(?,?,?,?,?)";

        Connection connection1=null;
        Statement statement1=null;

        try {
            Connection connection= DriverManager.getConnection(jdbcurl,userName,password);
         PreparedStatement preparedStatement= connection.prepareStatement(preparedQuery);

for(MetroDTO value:metroList)
{
    preparedStatement.setInt(1,value.getId());
    preparedStatement.setString(2,value.getName());
    preparedStatement.setString(3,value.getSource());
    preparedStatement.setString(4,value.getDestination());
    preparedStatement.setString(5,value.getState());
   boolean result= preparedStatement.execute();
    System.out.println(result);
}

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        finally {

            try {

                if(connection1!=null)
                connection1.close();
                System.out.println("Connection is closed");

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if(statement1!=null)
                statement1.close();
                System.out.println("Statement is closed");
            }
            catch (SQLException e)
            {
                throw new RuntimeException(e);
            }
        }

    }


}
