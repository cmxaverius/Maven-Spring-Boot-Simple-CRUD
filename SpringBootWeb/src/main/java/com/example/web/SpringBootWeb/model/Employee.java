package com.example.web.SpringBootWeb.model;

import javax.persistence.*;
//import javax.persistence.Id;
//import javax.persistence.Entity;
//import javax.persistence.Table;
//import javax.persistence.Column;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;

@Entity
@Table(name = "tblEmployee")
public class Employee {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer id;
	@Column (name = "employee_name") 
	private String name;
	private String department;
	
	@Version
	@Column(columnDefinition = "Integer DEFAULT 0")
	private Integer version;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
}
