package com.rgassignments;


import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOController implements EmployeeDAO {
    private PostgresConnector connector;

    public void setConnector(PostgresConnector connector) {
        this.connector = connector;
    }

    @Override
    public void createEmployee(Employee employee) throws SQLException {
        Connection connection = connector.getConnection();
        String sql = "INSERT INTO employees (id, name, department) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, employee.getId());
        statement.setString(2, employee.getName());
        statement.setString(3, employee.getDepartment());
        System.out.println(employee);
        statement.executeUpdate();
        statement.close();
        connection.close();
        System.out.println("Employee added successfully!");
    }
    @Override
    public Employee getEmployee(int id) throws SQLException {
        Connection connection = connector.getConnection();
        String sql = "SELECT * FROM employees WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        Employee employee = null;
        if (resultSet.next()) {
            id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String department = resultSet.getString("department");
            employee = new Employee();
            employee.setId(id);
            employee.setName(name);
            employee.setDepartment(department);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() throws SQLException {
        Connection connection = connector.getConnection();
        String sql = "SELECT * FROM employees";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<Employee> employees = new ArrayList<Employee>();
        System.out.println("Employee list: (id, name, department)");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String department = resultSet.getString("department");
            System.out.println(id + "\t" + name + "\t" + department);
            Employee employee = new Employee();
            employee.setId(id);
            employee.setName(name);
            employee.setDepartment(department);
            employees.add(employee);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return employees;
    }

    @Override
    public void updateEmployee(Employee employee) throws SQLException {
        Connection connection = connector.getConnection();
        String sql = "UPDATE employees SET name = ?, department = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, employee.getName());
        statement.setString(2, employee.getDepartment());
        statement.setInt(3, employee.getId());
        int rowsUpdated = statement.executeUpdate();
        statement.close();
        connection.close();
        if (rowsUpdated > 0) {
            System.out.println("Employee updated successfully!");
        } else {
            System.out.println("Employee with ID " + employee.getId() + " not found!");
        }
    }

    @Override
    public void deleteEmployee(int id) throws SQLException {
        Connection connection = connector.getConnection();
        String sql = "DELETE FROM employees WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        int rowsDeleted = statement.executeUpdate();
        statement.close();
        connection.close();
        if (rowsDeleted > 0) {
            System.out.println("Employee deleted successfully!");
        } else {
            System.out.println("Employee with ID " + id + " not found!");
        }
    }
}
