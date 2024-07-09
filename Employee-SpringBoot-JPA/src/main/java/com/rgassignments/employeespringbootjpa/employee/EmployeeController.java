package com.rgassignments.employeespringbootjpa.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping(path = "{employeeId}")
    public Employee getEmployeeById(@PathVariable("employeeId") long id) {
        return employeeService.getEmployee(id);
    }

    @PostMapping
    public void createEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @DeleteMapping(path = "{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") long id) {
        employeeService.deleteEmployeeById(id);
    }

    @PutMapping(path = "{employeeId}")
    public void updateEmployee(@PathVariable long id, @RequestParam String name, @RequestParam String department) {
        employeeService.updateEmployee(id, name, department);
    }
}
