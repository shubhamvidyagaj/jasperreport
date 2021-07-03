package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("test")
	public void getTest() {
	   System.out.println("testing for git and github repository");	
	}
}
