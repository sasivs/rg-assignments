package com.rgassignments;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Employee employee1 = new Employee();
        employee1.setId(1);
        employee1.setName("Peter Parker");
        employee1.setDepartment("Engineering");
        Employee employee2 = new Employee();
        employee2.setId(2);
        employee2.setName("MJ");
        employee2.setDepartment("Engineering");
        EmployeeDAOController employeeDAOController = (EmployeeDAOController) context.getBean("employeeDAOController");
        try{
            employeeDAOController.createEmployee(employee1);
            employeeDAOController.createEmployee(employee2);

            employeeDAOController.getAllEmployees();

            Employee employee3 = employeeDAOController.getEmployee(2);
            System.out.println("Employee with ID " + employee3.getId() + " found!");

            employee3.setName("Gwen Stacy");
            employee3.setDepartment("Biological Engineering");
            employeeDAOController.updateEmployee(employee3);

            List<Employee> employees = employeeDAOController.getAllEmployees();

            employeeDAOController.deleteEmployee(2);
            employeeDAOController.getAllEmployees();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}