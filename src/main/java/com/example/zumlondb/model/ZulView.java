package com.example.zumlondb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ZUL_VIEW")
public class ZulView implements Serializable{
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	@Getter @Setter
	private Integer id;
	
	@Getter @Setter
	@Column(name = "PATH")
	private String path;
	
	@Getter @Setter
	@Column(name = "ZUL")
	private String zul;

}
