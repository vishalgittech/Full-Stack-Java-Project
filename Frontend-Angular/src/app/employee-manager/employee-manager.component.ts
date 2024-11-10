import { Component, OnInit } from '@angular/core';
import { EmployeeService, Employee } from '../employee.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-employee-manager',
  standalone: true,
  templateUrl: './employee-manager.component.html',
  imports: [FormsModule, CommonModule]
})
export class EmployeeManagerComponent implements OnInit {
  employees: Employee[] = [];
  selectedEmployee: Employee = { name: '', department: '', salary: 0 };
  isEditMode = false;

  constructor(private employeeService: EmployeeService) {}

  ngOnInit(): void {
    this.fetchEmployees();
  }

  fetchEmployees(): void {
    this.employeeService.getEmployees().subscribe((data) => {
      this.employees = data;
    });
  }

  saveEmployee(): void {
    if (this.isEditMode) {
      this.employeeService.updateEmployee(this.selectedEmployee.id!, this.selectedEmployee).subscribe(() => {
        this.resetForm();
        this.fetchEmployees();
      });
    } else {
      this.employeeService.createEmployee(this.selectedEmployee).subscribe(() => {
        this.resetForm();
        this.fetchEmployees();
      });
    }
  }

  editEmployee(employee: Employee): void {
    this.selectedEmployee = { ...employee };
    this.isEditMode = true;
  }

  deleteEmployee(id: number): void {
    this.employeeService.deleteEmployee(id).subscribe(() => {
      this.fetchEmployees();
    });
  }

  resetForm(): void {
    this.selectedEmployee = { name: '', department: '', salary: 0 };
    this.isEditMode = false;
  }
}
