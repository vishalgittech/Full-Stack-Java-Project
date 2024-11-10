package com.EmployeeManagement.employee_CRUD.Controllers;

import com.EmployeeManagement.employee_CRUD.Models.Employee;
import com.EmployeeManagement.employee_CRUD.Services.Emp_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:4200")

public class EmpController {

    @Autowired
    private Emp_Service emp_Service;

    @GetMapping
    public List<Employee> getEmployees() {
        return emp_Service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeByID(@PathVariable Long id) {
        Optional<Employee> employee = emp_Service.getEmployeeById(id);
        if (employee.isPresent()) {
            return ResponseEntity.ok(employee.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return emp_Service.createEmployee(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        try {
            Employee updatedEmployee = emp_Service.updateEmployee(id, employee);
            return ResponseEntity.ok(updatedEmployee);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        emp_Service.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
