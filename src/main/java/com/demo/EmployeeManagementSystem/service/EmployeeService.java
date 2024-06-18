package com.demo.EmployeeManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.EmployeeManagementSystem.model.Employee;
import com.demo.EmployeeManagementSystem.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	public Employee addEmployee(Employee employee) {
		return empRepo.save(employee);

	}

	public List<Employee> addAllEmployees(List<Employee> employees) {
		return empRepo.saveAll(employees);
	}

	public Employee findEmployeeById(int id) {
		return empRepo.findById(id).orElse(null);
	}

	public Employee findEmployeeByName(String name) {
		return empRepo.findByName(name);
	}

	public List<Employee> findAllEmployees() {
		return empRepo.findAll();
	}

	public Employee updateTheEmployeeById(int id, Employee employee) {
		Employee existingEmp = empRepo.findById(id).orElse(null);
		if (existingEmp != null) {
			existingEmp.setName(employee.getName());
			existingEmp.setEmail(employee.getEmail());
			existingEmp.setSalary(employee.getSalary());
			return empRepo.save(existingEmp);
		} else {
			throw new RuntimeException("Employee not found with id: " + id); // Or handle as needed
		}
	}

	public boolean deleteTheEmployee(int id) {
		Employee existingEmp = empRepo.findById(id).orElse(null);
		if (existingEmp != null) {
			empRepo.deleteById(id);
			return true;
		} else {
			throw new RuntimeException("Employee not found with id: " + id); // Or handle as needed
		}
	}

}
