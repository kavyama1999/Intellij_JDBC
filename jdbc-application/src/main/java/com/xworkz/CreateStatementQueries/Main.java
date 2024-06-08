package com.xworkz.CreateStatementQueries;

import java.sql.DriverManager;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {

        //step to connect jdbc to database
//sout
        System.out.println("Hello jdbc");
//        //1.Load and Register Driver

        try {
                       //fully qualified className packageName+className

            Class.forName("com.mysql.jdbc.Driver");//FQN..1st 3 package and last is class name
            System.out.println("load and register driver"); //catch the ClassNotFoundException will occur when classNames are not define correctly

        }
        catch (ClassNotFoundException e) //if not given Driver class correctly throw an runtimeException

        {

            System.out.println("connection to jdbc is fail");
            throw new RuntimeException(e);
            //System.out.println("Exception while loading the class ");
        }


        finally {
            System.out.println("finally is optional when piece of code in a try block is not throw an exception");
        }


        //2.connect to database

        //mainPortal:subPortal://localhost:portNumber/database
        String jdbcurl="jdbc:mysql://localhost:3306/metro";  // not giving (//) java.sql.SQLException: No suitable driver found for jdbc:mysql:localhost:3306/metro
        String username="root";
        String password="Xworkzodc@123";
        System.out.println("get connection started with database!!!!!");
        try {
            DriverManager.getConnection(jdbcurl,username,password); //Access denied for interchange username and password
        }
        catch (SQLException e)
        {
            System.out.println("jdfj");

            throw new RuntimeException(e);
        }


    }
}



//
//package com.xworkz;
//
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
////TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
//// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//public class Main
//{
//    public static void main(String[] args)
//    {
//        //1.Load and Register Driver
//
//        try {
//            //fully qualified className packageName+className
//            Class.forName("com.mysql.jdbc.Driver");  //if not given Driver class correctly throw an runtimeException
//            System.out.println("load and register driver"); //catch the ClassNotFoundException will occur when classNames are not define correctly
//        } catch (ClassNotFoundException e)
//        {
//            System.out.println("Exception while loading the class ");
//            throw new RuntimeException(e);
//        }
//        finally {
//            System.out.println("finally is optional when piece of code in a try block is not throw an exception");
//        }
//
//
//        //2.connect to database
//
//        //mainPortal:subPortal://localhost:portNumber/database
//        String jdbcurl="jdbc:mysql://localhost:3306/metro";  // not giving (//) java.sql.SQLException: No suitable driver found for jdbc:mysql:localhost:3306/metro
//        String username="root";
//        String password="Xworkzodc@123";
//        try
//        {
//            System.out.println("get connection started with database!!!!!");
//            DriverManager.getConnection(jdbcurl,username,password); //Access denied for interchange username and password
//        }
//        catch (SQLException e)
//        {
//            System.out.println("problem!! connect to database");
//            throw new RuntimeException(e);
//        }
//
//
//    }
//}