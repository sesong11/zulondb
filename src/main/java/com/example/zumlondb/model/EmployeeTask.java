package com.example.zumlondb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "EMP_EMPLOYEE_TASK")
public class EmployeeTask implements Serializable, Comparable<EmployeeTask>{
	private static final long serialVersionUID = 7407486019861958268L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

	@Getter @Setter
    @Column(name = "NAME")
	@NotBlank(message =  "Name is required")
    private String name;
	
	@Getter @Setter
    @Column(name = "NOTE")
    private String note;
	
	@JoinColumn(name = "EMPLOYEE_ID")
    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY)
	private Employee employee;
	
	public static EmployeeTask create(String name, String note, Employee employee) {
		EmployeeTask task = new EmployeeTask();
		task.setName(name);
		task.setNote(note);
		task.setEmployee(employee);
		return task;
	}
	
	@Override
	public int compareTo(EmployeeTask o) {
		if(getId() == null) return -1;
		return this.getId().compareTo(o.getId());

	}
}
