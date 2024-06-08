package com.xworkz.CreateStatementQueries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {


    public static void main(String[] args) {

        System.out.println("Load and register drives class");
//load and register Driver class
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }

        String jdbcurl="jdbc:mysql://localhost:3306/metro";
        String username="root";
        String password="Xworkzodc@123";

        System.out.println("connecting to database");
//insert data here
        
    // String insertQuery="INSERT INTO nammametro(id,name,source,destination,state)VALUES  (5,'purple','mg road','Tinfactory','karnataka')";
                //(3,'Yellow','Baiyapanahalli','Majestic','karnataka')";
       //

       // String insertQuery1="INSERT INTO  nammametro(id,name,source,destination,state) VALUES (6,'velicity line','benniganahhali','swamivevakanda','karnataka')";
        //String insertQuery2="INSERT INTO  nammametro(id,name,source,destination,state) VALUES (7,'Lumin express ','SMVT','Kabban park','karnataka')";
        //String insertQuery3="INSERT INTO  nammametro(id,name,source,destination,state) VALUES (8,'Nexus rail ','whitefield','tifactory','karnataka')";
        //String insertQuery4="INSERT INTO  nammametro(id,name,source,destination,state) VALUES (9,'aurora transit ','btm','hebbbala','karnataka')";
        //String insertQuery5="INSERT INTO  nammametro(id,name,source,destination,state) VALUES (10,'zenith line ','banashakari','halsur','karnataka'),(11,'stellar express ','shivamogga','bengaluru','karnataka')";

        // String insertQuery23="INSERT INTO nammametro(id,name,source,destination,state)VALUES  (50,'green','K r puram ','Tinfactory','karnataka')";


        Connection connection1=null;

        try {

            System.out.println("Get connection started");

       Connection connection= DriverManager.getConnection(jdbcurl,username,password);//sql exception
            System.out.println("Established a connection from database!!!!!!!!!!!!!!!!!!!");
     Statement statement= connection.createStatement();//3).create statement
//   boolean execute=   statement.execute(insertQuery);//4).execute the sql query
//            System.out.println(execute);
//            boolean execute1=   sta
//            tement.execute(insertQuery1);
//            System.out.println(execute1);
           // boolean execute2=   statement.execute(insertQuery2);
            //System.out.println(execute2);
            //boolean execute3=   statement.execute(insertQuery3);
            //System.out.println(execute3);
           // boolean execute4=   statement.execute(insertQuery4);
            //System.out.println(execute4);
//            boolean execute5=   statement.execute(insertQuery5);
//            System.out.println(execute5);
//extra
           // boolean execute50=   statement.execute(insertQuery23);
            //System.out.println(execute50);


            //5)..then process resultant data..
            //6)..close the costly resorce ..we have  have create object and then assign to null for that
        }
        catch (SQLException e)
        {
            //System.out.println("connection is successfull");
            throw new RuntimeException(e);
        }

        finally
        {
            try {
                if(connection1!=null)
                connection1.close();  //it will get nullpointerexception..
                                        // to avoid we can put if condition like if(connection1!=null)
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Connection is closed");
        }









    }
}