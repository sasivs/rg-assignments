package com.rgassignments.employeespringbootjpa.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public void addEmployee(Employee employee) {
        boolean exists = employeeRepository.existsById(employee.getId());
        if (exists) {
            throw new IllegalStateException("Employee with " + employee.getId() + " already exists!");
        }
        employeeRepository.save(employee);
    }

    public void deleteEmployeeById(long id) {
        boolean exists = employeeRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Employee with " + id + " does not exists!");
        }
        employeeRepository.deleteById(id);
    }

    @Transactional
    public void updateEmployee(long id, String name, String department) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new IllegalStateException("Employee with " + id + " does not exists!"));

        if (name != null && !name.isEmpty() && !Objects.equals(employee.getName(), name)) {
            employee.setName(name);
        }
        if (department != null && !department.isEmpty() && !Objects.equals(employee.getDepartment(), department)) {
            employee.setDepartment(department);
        }
    }

    public Employee getEmployee(long id) {
        return employeeRepository.findById(id).orElse(null);
    }
}
