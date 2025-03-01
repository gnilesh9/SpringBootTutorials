package com.swagger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swagger.model.Employee;
import com.swagger.model.EmployeeRequest;
import com.swagger.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/employees")
@Tag(name = "Employee API", description = "Manage employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Operation(summary = "Get all employees", description = "Fetches all employees from the database")
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @Operation(summary = "Get an employee by ID", description = "Fetches an employee by their unique ID")
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @Operation(summary = "Create a new employee", description = "Adds a new employee to the database")
    @PostMapping
    public Employee createEmployee(@RequestBody EmployeeRequest employee) {
        return employeeService.createEmployee(employee);
    }

    @Operation(summary = "Update an existing employee", description = "Modifies details of an existing employee")
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        return employeeService.updateEmployee(id, employeeDetails);
    }

    @Operation(summary = "Delete an employee", description = "Removes an employee from the database")
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

}


