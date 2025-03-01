package com.swagger.service;

import java.util.List;

import com.swagger.model.Employee;
import com.swagger.model.EmployeeRequest;

public interface EmployeeService {

	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeById(Long id);
	
	public Employee createEmployee(EmployeeRequest employee);
	
	public Employee updateEmployee(Long id, Employee employeeDetails);
	
	public void deleteEmployee(Long id);

}
