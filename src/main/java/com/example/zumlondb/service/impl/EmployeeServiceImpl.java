package com.example.zumlondb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.zumlondb.model.Employee;
import com.example.zumlondb.repository.EmployeeRepository;
import com.example.zumlondb.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository repo;
	
	@Override
	public Employee save(Employee employee) {
		return repo.save(employee);
	}

	@Override
	public Employee findBy(int id) {
		var opt = repo.findById(id);
		return opt.isPresent()?opt.get():null;
	}

	@Override
	public List<Employee> findAll() {
		return repo.findAll();
	}

	@Override
	public void delete(Employee employee) {
		repo.delete(employee);
	}

}
