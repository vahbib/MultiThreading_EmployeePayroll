package com.mutlithread;

import java.sql.Date;

public class Employee {

    private int id;
    private String name;
    private char gender;
    private double salary;
    private String date;
    private String department;
    private String active;

    public Employee(String name, char gender, double salary, String date, String department, String active) {
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.date = date;
        this.department = department;
        this.active = active;
    }

    public Employee(int id, String name, char gender, double salary, String date, String active) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.date = date;
        this.active = active;
    }

    public Employee(int id, String name, char gender, double salary, String date) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.date = date;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public double getSalary() { return salary; }

    public void setSalary(double salary) { this.salary = salary; }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }
    public char getGender() { return gender;}
    public void setGender(char gender) { this.gender = gender; }
}