package com.mutlithread;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    int counterConnection = 0;
    Connection con = null;


    public synchronized Connection getConnection(){
        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
        String userName = "root";
        String password = "Asep@25355";

        counterConnection++;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded..");
        }catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath", e);
        }
        try {
            System.out.println("Connecting to the Database... " + jdbcURL);
            con = DriverManager.getConnection(jdbcURL, userName, password);


            System.out.println("Processing Thread: " + counterConnection);
            System.out.println("Connection was successful !!");
        }catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}