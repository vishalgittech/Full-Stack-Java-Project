package com.EmployeeManagement.employee_CRUD.Models;



import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "emp_name")
    private String name;

    @Column(name = "department")
    private String department;

    @Column(name = "salary")
    private double salary;
}

