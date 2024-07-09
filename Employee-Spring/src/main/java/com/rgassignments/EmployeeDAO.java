package com.rgassignments;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
    public void createEmployee(Employee employee) throws SQLException;
    public Employee getEmployee(int id) throws SQLException;
    public List<Employee> getAllEmployees() throws SQLException;
    public void updateEmployee(Employee employee) throws SQLException;
    public void deleteEmployee(int id) throws SQLException;
}
