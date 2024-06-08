package com.xworkz.dao;

public class MetroDAORunner {


    public static void main(String[] args) {


//MetroDAOImpl metroDAO=new MetroDAOImpl();
        MetroDAO metroDAO=new MetroDAOImpl();


//metroDAO.insert();

        metroDAO.delete();
        metroDAO.update();
        metroDAO.fetch();




        }
}
