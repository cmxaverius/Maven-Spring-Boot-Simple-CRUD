package com.example.web.SpringBootWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.web.SpringBootWeb.model.Employee;
import com.example.web.SpringBootWeb.service.EmployeeService;


@Controller
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	
	@Autowired
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}


	@RequestMapping("/employee")
	public String employeeList(Model model){
		model.addAttribute("employee", employeeService.listEmployee());
		return "Employee";
	}
	
	@RequestMapping(value = "/employee/create", method = RequestMethod.GET)
	public String formEmployee(Model model){
		model.addAttribute("employee",new Employee());
		return "formEmployee";
	}
	
	@RequestMapping(value = "/employee/create", method = RequestMethod.POST)
	public String saveEmployee(Model model, Employee employee){
		model.addAttribute("employee", employeeService.EmployeeSaveUpdate(employee));
		return "redirect:/employee";
	}
	
	@RequestMapping(value="/employee/edit/{id}", method = RequestMethod.GET)
	public String editEmployee(@PathVariable Integer id, Model model){
		model.addAttribute("employee", employeeService.getIdEmployee(id));
		return "formEmployee";
	}
	
	@RequestMapping(value="/employee/delete/{id}")
	public String deleteEmployee(@PathVariable Integer id){
		employeeService.deleteEmployee(id);
		return "redirect:/employee";
	}
}
