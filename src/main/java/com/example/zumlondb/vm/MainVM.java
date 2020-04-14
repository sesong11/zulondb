package com.example.zumlondb.vm;

import java.util.Objects;

import javax.validation.Path;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Size;

import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Notification;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;
import org.zkoss.zul.ListModelList;

import com.example.zumlondb.model.Employee;
import com.example.zumlondb.model.EmployeeTask;
import com.example.zumlondb.service.EmployeeService;

import lombok.Getter;
import lombok.Setter;


@VariableResolver(DelegatingVariableResolver.class)
public class MainVM {
	
	//Inject Service
	@WireVariable
	EmployeeService employeeService;
	
	//Fields	
	@Getter
	private ListModelList<Employee> employees;
	
	@Getter @Setter
	private Employee employee = new Employee();
	
	@Init
	public void init() {
		employees = new ListModelList<>(employeeService.findAll());
	}
	
	@Command
	@NotifyChange({"employee", "employees"})
	public void save() {
		employees.remove(employee);
		employee = employeeService.save(employee);
		employees.add(employee);
		Notification.show("Save Successed");
	}
	
	@Command
	@NotifyChange("employee")
	public void clear() {
		employee = new Employee();
	}
	
	@Command
	@NotifyChange("employee")
	public void delete() {
		employeeService.delete(employee);
		if(employees.remove(employee)) {
			Notification.show("Delete Successed");
			clear();
		}
	}
	
	@Command
	@NotifyChange("employee")
	public void addTask() {
		employee.addTask(EmployeeTask.create("", "", employee));
	}
	
	public org.zkoss.bind.Validator getFormValidator() {
	    return new AbstractValidator() {
	        public void validate(ValidationContext ctx) {
	        	ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
	        	Validator validator = vf.getValidator();
	        	var violations = validator.validate(employee);
	        	for(var v : violations) {
	                String message = v.getMessage();
	                Path path = v.getPropertyPath();
	                addInvalidMessage(ctx, path.toString(), message);
	            }
	        }
	    };
	}
}
