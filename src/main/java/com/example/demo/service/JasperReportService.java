package com.example.demo.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class JasperReportService {
	
	@Autowired
	private EmployeeRepository repository;

	public String exportReport(String format) throws FileNotFoundException, JRException {
		String path="C:\\Users\\shubhangee\\Desktop";
		List<Employee> emp=(List<Employee>) repository.findAll();
		// load and compile jrxml file
		File file = ResourceUtils.getFile("classpath:employees.jrxml");
		JasperReport jasperReport=JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource datasource=new JRBeanCollectionDataSource(emp);
		Map<String,Object> map=new HashedMap();
		map.put("created by", "shubham");
		JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport,map, datasource);
		if(format.equalsIgnoreCase("html")) {
			JasperExportManager.exportReportToHtmlFile(jasperPrint,path+"\\employees.html");
		}
		
        if(format.equalsIgnoreCase("pdf")) {
        	JasperExportManager.exportReportToPdfFile(jasperPrint,path+"\\employees.pdf");
		}
			
			return "report generted in path"+path;
	}
}
