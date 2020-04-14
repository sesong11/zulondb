package com.example.zumlondb.fixturescript;

import javax.annotation.Priority;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.zumlondb.model.Employee;
import com.example.zumlondb.model.EmployeeTask;
import com.example.zumlondb.service.EmployeeService;

@Component
@Priority(1)
public class EmployeeFixture implements ApplicationRunner{

	@Autowired
	EmployeeService employeeService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Employee employee = Employee.create("Se Song", "se.song@sathapana.com.kh", "In-house Team");
		EmployeeTask task = EmployeeTask.create("Create a project", "Use Spring boot", employee);
		employee.addTask(task);
		employeeService.save(employee);
		
		
	}

}
