package com.demo.EmployeeManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.EmployeeManagementSystem.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	Employee getByName(String name);

	Employee findByName(String name);
}
