package com.example.springcache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.springcache.domain.Student;
import com.example.springcache.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	@Qualifier(value ="std1")
	Student std;
	
	@GetMapping("/student/{id}")
	public Student findStudentById(@PathVariable String id) {
		System.out.println("Searching by ID  : " + id);
		return studentService.getStudentByID(id);
	}
	@GetMapping("/student")
	public Student findStudentByBean() {
		
		return std;
	}
}
