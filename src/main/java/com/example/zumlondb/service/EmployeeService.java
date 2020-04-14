package com.example.zumlondb.service;

import java.util.List;

import com.example.zumlondb.model.Employee;

public interface EmployeeService {
	Employee save(Employee employee);
	Employee findBy(int id);
	List<Employee> findAll();
	void delete(Employee employee);
}
