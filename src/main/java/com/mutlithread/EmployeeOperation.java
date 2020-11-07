package com.mutlithread;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeOperation {

    static List<Employee> employee_list = new ArrayList<>();
    private PreparedStatement preparedStatement;
    private static EmployeeOperation employeeOperation;
    public static List<Employee> getEmployee_list() {
        return employee_list;
    }

}
