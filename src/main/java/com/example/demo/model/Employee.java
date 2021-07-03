package com.example.demo.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "empdetails")
@Data
public class Employee {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eid;
    private String ename;
    private int  deptid;
    private Long salary;
    private Long commision;
    private String designation;
    private Long mgrid;
    private String gender; 
    private Date hiredata;
}
