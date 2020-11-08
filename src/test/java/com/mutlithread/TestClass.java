package com.mutlithread;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

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
    @Test
    public void insertEmployeeDateOnSuccessfulUpdatingOfDatabase() throws SQLException, JDBCCustomException {

//        eo.insertDataToEmployeeDB(con,"Chinmoi", 'F',450000, "2016-03-05", "Advertisement");

        eo.readData(con);
        Statement stmt = con.createStatement();
        String query =  "Select * from employee_payroll";
        ResultSet rs = stmt.executeQuery(query);
        Employee emp = null;
        while(rs.next()){
            int id = rs.getInt(1);
            String name = rs.getString(2);
            char gender = rs.getString(3).charAt(0);
            double salary = rs.getDouble(4);
            String date1 = rs.getString(5);
            String active = rs.getString(6);
            emp = new Employee(id,name,gender,salary,date1,active);
        }
        int c = eo.countNumEntries(con);
        Assert.assertEquals(13, c);

    }
    @Test
    public void check_AdditionOfEmployeeWithThreadExecutionTime() throws SQLException, JDBCCustomException {
        eo.readData(con);
        Instant start = Instant.now();
        eo.insertDataToEmployeeDB(con,"Alok",'M',650000,"2018-03-05","Finance");
        Instant end = Instant.now();

        System.out.println("Duration of execution : " + Duration.between(start,end));
        int count = eo.countNumEntries(con);
        Assert.assertEquals(14, count);

        Employee[] emp = {
                new Employee("Pamela",'F',650000,"2019-02-25","Finance","Yes"),
                new Employee("Shruti",'F',550000,"2018-02-02","Marketing","Yes")
        };
        Instant startThread = Instant.now();
        eo.addEmployeeThreads(con, Arrays.asList(emp));
        Instant endThread = Instant.now();
        System.out.println("Duration of execution with Threads : " + Duration.between(startThread, endThread));
        int count1 = eo.countNumEntries(con);
        Assert.assertEquals(16, count1);
    }

}