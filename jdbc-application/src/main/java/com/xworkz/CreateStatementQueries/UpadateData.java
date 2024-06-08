package com.xworkz.CreateStatementQueries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpadateData {

    public static void main(String[] args) {

        System.out.println("Load and register drives class");

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String jdbcurl="jdbc:mysql://localhost:3306/metro";
        String username="root";
        String password="Xworkzodc@123";

        System.out.println("connecting to database");
      //  String insertQuery="INSERT INTO nammametro(id,name,source,destination,state)VALUES (3,'Yellow','Baiyapanahalli','Majestic','karnataka')";
        //update voters_information set voter_name = 'Kavya' where address = 'Shivamogga' AND age = 24 and id = 110;

        String updateQuery="UPDATE  nammametro set source='vijayanagar' where  id=2";
        String updateQuery1="UPDATE  nammametro set destination='kengeri' where  state='karnataka'";//it will change to all which state has karnataka
        String updateQuery2="UPDATE  nammametro set source='Mg road' where  id=3";
        String updateQuery3="UPDATE  nammametro set source='vijayanagar' where  id=4";
        String updateQuery4="UPDATE  nammametro set destination='vijayanagar' where  id=5";
       // String updateQuery5="UPDATE  nammametro set source='vijayanagar' where  id=6";
        String updateQuery6="UPDATE  nammametro set source='shantinagar' where  id=7";
        String updateQuery7="UPDATE  nammametro set destination='silkborad' where  id=8";
        String updateQuery8="UPDATE  nammametro set destination='emc' where  id=9";
        String updateQuery9="UPDATE  nammametro set destination='hsr layout' where  id=10";
        String updateQuery10="UPDATE  nammametro set source='rajajinagar' where  id=11";
String updateQuery11="UPDATE nammametro set source='Marathalli' where id=25";


Connection connect=null;
        try {
            System.out.println("connection get started");
    Connection connection= DriverManager.getConnection(jdbcurl,username,password);
    Statement statement= connection.createStatement();

  //boolean result=  statement.execute(updateQuery);
       int result=     statement.executeUpdate(updateQuery);
            System.out.println(result);
            //
            boolean result1=  statement.execute(updateQuery1);
            System.out.println(result1);
            //
            boolean result2=  statement.execute(updateQuery2);
            System.out.println(result2);
            boolean result3=  statement.execute(updateQuery3);
            System.out.println(result3);
            boolean result4=  statement.execute(updateQuery4);
            System.out.println(result4);
            boolean result6=  statement.execute(updateQuery6);
            System.out.println(result6);
            boolean result7=  statement.execute(updateQuery7);
            System.out.println(result7);
            boolean result8=  statement.execute(updateQuery8);
            System.out.println(result8);
            boolean result9=  statement.execute(updateQuery9);
            System.out.println(result9);
            boolean result10=  statement.execute(updateQuery10);
            System.out.println(result10);

            int result11=  statement.executeUpdate(updateQuery11);//1 again update adre 0
            System.out.println(result11);



        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        //5)..then process resultant data..
        //6)..close the costly resorce ..we have  have create object and then assign to null for that

        finally
        {
            try {
                if(connect!=null)
                connect.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
