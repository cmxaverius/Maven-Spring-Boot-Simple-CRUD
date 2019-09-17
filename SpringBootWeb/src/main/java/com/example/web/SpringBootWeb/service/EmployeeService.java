package com.example.web.SpringBootWeb.service;

import java.util.List;

import com.example.web.SpringBootWeb.model.Employee;

public interface EmployeeService {
	
	List <Employee> listEmployee();
	
	Employee EmployeeSaveUpdate(Employee employee);
	
	Employee getIdEmployee(Integer id);
	
	void deleteEmployee(Integer id);
	
}
