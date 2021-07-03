package com.example.demo.controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.JasperReportService;

import net.sf.jasperreports.engine.JRException;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository repository;
	
	@Autowired
	private JasperReportService service;

	@GetMapping("/employee")
	public List<Employee> getEmployees() {
		return  (List<Employee>) repository.findAll();
	}
	
	@GetMapping("/report/{format}")
	public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
		return  service.exportReport(format);
	}
}
