package com.EmployeeManagement.employee_CRUD.Repository;


import com.EmployeeManagement.employee_CRUD.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Emp_Repo extends JpaRepository<Employee, Long> {
}
