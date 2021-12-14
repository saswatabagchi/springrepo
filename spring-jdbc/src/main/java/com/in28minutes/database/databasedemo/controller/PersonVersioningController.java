package com.in28minutes.database.databasedemo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jdbc.PersonJbdcDao;
import com.in28minutes.database.databasedemo.resttempalte.Employee;
import com.in28minutes.database.databasedemo.resttempalte.SpringRestClient;








@RestController
@RequestMapping("/api/v1")
public class PersonVersioningController {

	
		@Autowired
		private PersonJbdcDao personJbdcDao;
        
		@Autowired
		private SpringRestClient restclient;
		
	
		
		
		@GetMapping("/person")
		public List<Person> getAllPersons() throws JsonMappingException, JsonProcessingException {
			List<Employee> emplist = restclient.getEmployees();
			return personJbdcDao.findAll();
		}
		
		@GetMapping("/person/{id}")
		public ResponseEntity<Person> getPesrsonById(@PathVariable(value = "id") int personId) throws JsonMappingException, JsonProcessingException
				 {
			Person person = personJbdcDao.findById(personId);
			String empId = String.valueOf(personId);
			Employee emp = restclient.getEmployeeById(empId);	
			return ResponseEntity.ok().body(person);
		}
		 
		@PostMapping("/person")
		public int createEmployee(@Valid @RequestBody Person person) {
			restclient.createEmployee();
			return personJbdcDao.save(person);
		}
		
		@PutMapping("/person/{id}")
		public ResponseEntity<Person> updateEmployee(@PathVariable(value = "id") int personId,
				@Valid @RequestBody Person person)  {
			int response = personJbdcDao.update(person);
			return ResponseEntity.ok(person);
		}

		@DeleteMapping("/person/{id}")
		public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") int personId )
				 {
			personJbdcDao.deleteById(personId);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
		}

		
	
}
