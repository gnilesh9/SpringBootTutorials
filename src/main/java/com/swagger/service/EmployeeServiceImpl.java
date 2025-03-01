package com.swagger.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swagger.model.Employee;
import com.swagger.model.EmployeeRequest;
import com.swagger.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).orElse(null);
	}

	@Override
	public Employee createEmployee(EmployeeRequest employeeRequest) {
		Employee  employee= new Employee();
		employee.setName(employeeRequest.getName());
		employee.setEmail(employeeRequest.getEmail());
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Long id, Employee employeeDetails) {
		 Optional<Employee> optionalEmployee = employeeRepository.findById(id);
	        if (optionalEmployee.isPresent()) {
	            Employee existingEmployee = optionalEmployee.get();
	            existingEmployee.setName(employeeDetails.getName());
	            existingEmployee.setEmail(employeeDetails.getEmail());
	            return employeeRepository.save(existingEmployee);
	        }
	        return null;
	}

	@Override
	public void deleteEmployee(Long id) {
		 employeeRepository.deleteById(id);
		
	}

}
