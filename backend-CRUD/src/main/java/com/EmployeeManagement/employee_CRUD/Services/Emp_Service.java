package com.EmployeeManagement.employee_CRUD.Services;


import com.EmployeeManagement.employee_CRUD.Models.Employee;
import com.EmployeeManagement.employee_CRUD.Repository.Emp_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Emp_Service {

    @Autowired
    private Emp_Repo empRepository;

    public List<Employee> getAllEmployees(){

        return empRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return empRepository.findById(id);
    }

    public Employee createEmployee(Employee employee) {
        return empRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employee) {
        Employee emp = empRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        emp.setName(employee.getName());
        emp.setDepartment(employee.getDepartment());
        emp.setSalary(employee.getSalary());

        // Save the updated employee entity, not the original one
        return empRepository.save(emp);
    }

    public void deleteEmployee(Long id) {
        empRepository.deleteById(id);
    }
}
