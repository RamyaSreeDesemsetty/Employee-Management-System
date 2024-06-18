package com.demo.EmployeeManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.EmployeeManagementSystem.model.Employee;
import com.demo.EmployeeManagementSystem.service.EmployeeService;

@RestController
@RequestMapping("/emp")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	// Add new employee
	@PostMapping("/addEmployee")
	public Employee createEmployee(@RequestBody Employee employee) {
		return empService.addEmployee(employee);
	}

	// Add more than 1 employee
	@PostMapping("/addEmployees")
	public List<Employee> createAllEmployees(@RequestBody List<Employee> employees) {
		return empService.addAllEmployees(employees);
	}

	// Get employee by id
	@GetMapping("/getEmployeeById/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return empService.findEmployeeById(id);
	}

	// Get employee by name
	@GetMapping("/getEmployeeByName/{name}")
	public Employee getEmployeeByName(@PathVariable String name) {
		return empService.findEmployeeByName(name);
	}

	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees() {
		return empService.findAllEmployees();
	}

	// Update employee

	@PutMapping("/updateEmployeeById/{id}")
	public Employee updateEmployeeById(@PathVariable int id, @RequestBody Employee employee) {
		return empService.updateTheEmployeeById(id, employee);
	}

	// delete employee
	@DeleteMapping("/deleteEmployeeById/{id}")
	public boolean deleteEmployeeById(@PathVariable int id) {
		return empService.deleteTheEmployee(id);
	}

}
