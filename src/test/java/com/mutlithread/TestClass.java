package com.mutlithread;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.time.Duration;
import java.time.Instant;

public class TestClass {
    EmployeeOperation eo;
    DBConnection dbc;
    Connection con;
    @Before
    public void init() {

        eo = new EmployeeOperation();
        dbc = new DBConnection();
        con = dbc.getConnection();


    }
//    @Test
//    public void insertEmployeeDateOnSuccessfulUpdatingOfDatabase() throws SQLException, JDBCCustomException {
//
//        eo.insertDataToEmployeeDB(con,"Donna", 'F',450000, "2016-03-05", "Sales");
//
//        eo.readData(con);
//        Statement stmt = con.createStatement();
//        String query =  "Select * from employee where name = 'Donna'";
//        ResultSet rs = stmt.executeQuery(query);
//        Employee emp = null;
//        while(rs.next()){
//            int id = rs.getInt(1);
//            String name = rs.getString(2);
//            char gender = rs.getString(3).charAt(0);
//            double salary = rs.getDouble(4);
//            String date1 = rs.getString(5);
//            long phone = rs.getLong(6);
//            String address = rs.getString(7);
//            String department = rs.getString(8);
//            String cname = rs.getString(9);
//            String active = rs.getString(10);
//            emp = new Employee(id,name,gender,salary,date1,active);
//        }
//
//    }
    @Test
    public void check_AdditionOfEmployeeWithThreadExecutionTime() throws SQLException, JDBCCustomException {
        eo.readData(con);
        Instant start = Instant.now();
        eo.insertDataToEmployeeDB(con,"Jessica",'F',650000,"2018-03-05","Finance");
        Instant end = Instant.now();

        System.out.println("Duration of execution : " + Duration.between(start,end));
        int count = eo.countNumEntries(con);
        Assert.assertEquals(11, count);
    }

}
