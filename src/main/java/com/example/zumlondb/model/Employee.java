package com.example.zumlondb.model;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Table(name = "EMP_EMPLOYEE")
@Entity
public class Employee implements Serializable{
	private static final long serialVersionUID = -4086357167935259543L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
	
	@Getter @Setter
    @Column(name = "name")
	@NotBlank(message =  "Name is required")
    private String name;
		
	@Getter @Setter
    @Column(name = "email")
	@NotBlank(message =  "Email is required")
	@Email(message = "Email is invalid")
    private String email;
    
    @Getter @Setter
    @Column(name = "note", length = 1024)
    private String note;
    
    @Getter @Setter
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("id")
    @Valid
    private Set<EmployeeTask> tasks;
    
    public static Employee create(
    		final String name,
    		final String email,
    		final String note) {
    	Employee employee = new Employee();
    	employee.setName(name);
    	employee.setNote(note);
    	employee.setEmail(email);
    	return employee;
    }

	public void addTask(EmployeeTask task) {
		if(tasks == null) {
			tasks = new TreeSet<>();
		}
		tasks.add(task);
	}
}
